package com.itis.service;

import com.itis.dto.ProductDto;
import com.itis.models.Product;
import com.itis.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SearchProductServiceImpl implements SearchProductService {
    private ProductRepository productRepository;
    @Override
    public List<ProductDto> searchByProductName(String productName) {
        if(productName.equals(""))
            return new ArrayList<ProductDto>();
        List<Product> products = productRepository.getByNameIsLike("%" + productName + "%");
        return ProductDto.from(products);
    }
}
