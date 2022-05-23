package com.itis.service;

import com.itis.models.Client;
import com.itis.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmCodeServiceImpl implements ConfirmCodeService {
    private final ClientRepository clientRepository;

    @Override
    public boolean validateUser(String confirmCode) {
        Optional<Client> client = clientRepository.getClientByConfirmCode(confirmCode);
        client.ifPresent(value -> {
            value.setState(Client.State.CONFIRMED);
            clientRepository.save(value);
        });
        return client.isPresent();
    }
}
