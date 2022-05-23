package com.itis.service;

import com.itis.models.Client;
import com.itis.models.Order;
import com.itis.models.Product;
import com.itis.models.ProductQuantityLink;
import com.itis.repositories.ClientRepository;
import com.itis.repositories.OrderRepository;
import com.itis.repositories.ProductQLRepository;
import com.itis.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartMethodsServiceImpl implements CartMethodsService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CartPersistService cartPersistService;
    private final ProductQLRepository productQLRepository;
    private final ClientRepository clientRepository;


    @Override
    public void changeProductQuantity(Long quantity, Long productQLinkId) {
        ProductQuantityLink productQuantityLink = productQLRepository.getById(productQLinkId);
        productQuantityLink.setQuantity(quantity);
        productQLRepository.save(productQuantityLink);
    }

    @Override
    public void delete(Long productQuantityLinkId) {
        ProductQuantityLink pql = productQLRepository.getById(productQuantityLinkId);
        productQLRepository.delete(pql);
    }


    @Override
    public void addProduct(Client client, Long quantity, Long product_id) {
        Order order = cartPersistService.persistCart(client);
        Product product = productRepository.getById(product_id);
        ProductQuantityLink previousProduct = productQLRepository.getByOrderAndProduct(order, product);
        if(previousProduct != null){
            previousProduct.setQuantity(previousProduct.getQuantity() + quantity);
            productQLRepository.save(previousProduct);
            return;
        }
        ProductQuantityLink productQuantityLink = ProductQuantityLink.builder()
                .order(order)
                .quantity(quantity)
                .product(product)
                .build();
        productQLRepository.save(productQuantityLink);
    }

    @Override
    public void buy(Long clientId) {
        Client client = clientRepository.getById(clientId);
        Order order = cartPersistService.persistCart(client);
        order.setIsCart(false);
        orderRepository.save(order);
    }
}
