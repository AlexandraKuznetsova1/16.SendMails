package com.itis.repositories;

import com.itis.models.Order;
import com.itis.models.Product;
import com.itis.models.ProductQuantityLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductQLRepository extends JpaRepository<ProductQuantityLink, Long> {
    ProductQuantityLink getByOrderAndProduct(Order order, Product product);
}
