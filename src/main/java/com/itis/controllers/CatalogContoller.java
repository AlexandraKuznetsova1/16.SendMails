package com.itis.controllers;

import com.itis.dto.ProductDto;
import com.itis.models.Product;
import com.itis.models.Type;
import com.itis.repositories.ProductRepository;
import com.itis.repositories.TypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@AllArgsConstructor
@RequestMapping("/catalog")
public class CatalogContoller {
    private ProductRepository productRepository;
    private TypeRepository typeRepository;
    @GetMapping
    public String getPage(@RequestParam("type_id") Long type_id, Model model){
        Type type = typeRepository.getById(type_id);
        List<Product> products = productRepository.getByType(type);
        model.addAttribute("type", type.getName());
        model.addAttribute("products", ProductDto.from(products));
        return "catalog";
    }
}
