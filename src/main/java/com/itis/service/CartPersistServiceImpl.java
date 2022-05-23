package com.itis.service;

import com.itis.models.Client;
import com.itis.models.Order;
import com.itis.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartPersistServiceImpl implements CartPersistService {
    private final OrderRepository orderRepository;

    @Override
    public Order persistCart(Client client) {
        List<Order> orderList = orderRepository.findByClientAndIsCartTrue(client);
        if (orderList.size() != 1) {
            if (orderList.size() > 1)
                orderList.forEach(x -> x.setIsCart(false));
            Order order = Order.builder()
                    .client(client)
                    .isCart(true)
                    .build();
            orderRepository.save(order);
            return order;
        }
        return orderList.get(0);
    }
}
