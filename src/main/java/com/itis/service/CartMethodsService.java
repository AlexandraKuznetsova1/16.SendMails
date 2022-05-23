package com.itis.service;

import com.itis.models.Client;

public interface CartMethodsService {

    //change quantity of a product
    void changeProductQuantity(Long quantity, Long productQLinkId);

    //delete an item from a cart
    void delete(Long productQuantityLinkId);

    //add product to a cart
    void addProduct(Client client, Long quantity, Long product_id);

    //buy everything that is in the cart (order - isCart -> false)
    void buy(Long clientId);
}
