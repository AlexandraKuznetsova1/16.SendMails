package com.itis.dto;

import com.itis.models.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private String firstName;
    private String lastName;
    private String email;

    public static ClientDto from(Client client){
        return ClientDto.builder()
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .email(client.getEmail())
                .build();
    }
}
