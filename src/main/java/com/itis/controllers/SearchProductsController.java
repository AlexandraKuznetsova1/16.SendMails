package com.itis.controllers;

import com.itis.dto.ProductDto;
import com.itis.service.SearchProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/search_products")
public class SearchProductsController {
    private SearchProductService searchProductService;
    @GetMapping
    public String getPage(){
        return "search_products";
    }

    @RequestMapping(value = "/searchByName", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ProductDto> searchProductsByName(@RequestParam("prodName") String productName){
        return searchProductService.searchByProductName(productName);
    }
}
