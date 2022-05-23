package com.itis.repositories;

import com.itis.models.Client;
import com.itis.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByClientAndIsCartTrue(Client client);
}
