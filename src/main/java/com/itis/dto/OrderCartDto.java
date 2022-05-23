package com.itis.dto;

import com.itis.models.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCartDto {
    private Long order_id;
    private Long client_id;

    public static OrderCartDto from(Order order){
        return OrderCartDto.builder()
                .client_id(order.getClient().getId())
                .order_id(order.getId())
                .build();
    }
}
