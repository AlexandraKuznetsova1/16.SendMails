package com.itis.dto;

import com.itis.models.ProductQuantityLink;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductQLDto {
    private Long pql_id;
    private String name;
    private Long price;
    private Long quantity;
    public static ProductQLDto from(ProductQuantityLink productQuantityLink){
        return ProductQLDto.builder()
                .pql_id(productQuantityLink.getId())
                .name(productQuantityLink.getProduct().getName())
                .price(productQuantityLink.getProduct().getPrice())
                .quantity(productQuantityLink.getQuantity())
                .build();
    }

    public static List<ProductQLDto> from(List<ProductQuantityLink> productQuantityLinks){
        if(productQuantityLinks == null){
            return new ArrayList<ProductQLDto>();
        }
        return productQuantityLinks.stream()
                .map(ProductQLDto :: from).collect(Collectors.toList());
    }
}
