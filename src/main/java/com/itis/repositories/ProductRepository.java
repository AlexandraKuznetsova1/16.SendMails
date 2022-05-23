package com.itis.repositories;

import com.itis.models.Product;
import com.itis.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getByType(Type type);

    List<Product> getByNameIsLike(String name);
}
