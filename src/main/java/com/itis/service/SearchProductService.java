package com.itis.service;

import com.itis.dto.ProductDto;

import java.util.List;

public interface SearchProductService {
    List<ProductDto> searchByProductName(String productName);
}
