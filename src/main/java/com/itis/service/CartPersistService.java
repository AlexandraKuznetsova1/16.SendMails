package com.itis.service;

import com.itis.models.Client;
import com.itis.models.Order;

public interface CartPersistService {
    //ensures that exists an order with field 'is_cart' equal to true
    Order persistCart(Client client);
}
