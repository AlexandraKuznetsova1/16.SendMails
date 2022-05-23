package com.itis.dto;

import com.itis.models.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TypeDto {
    private Long type_id;
    private String name;
    public static TypeDto from(Type type){
        return TypeDto.builder()
                .type_id(type.getId())
                .name(type.getName())
                .build();
    }
    public static List<TypeDto> from(List<Type> types){
        return types.stream().map(TypeDto::from).collect(Collectors.toList());
    }
}
