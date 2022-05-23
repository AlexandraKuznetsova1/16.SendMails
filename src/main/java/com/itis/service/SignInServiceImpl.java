package com.itis.service;

import com.itis.dto.SignInForm;
import com.itis.models.Client;
import com.itis.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SignInServiceImpl implements SignInService {
    private final ClientRepository clientRepository;
    @Override
    public boolean signIn(SignInForm signInForm) {
        Optional<Client> client = Optional.ofNullable(clientRepository.getClientByEmail(signInForm.getEmail()));
        if(client.isEmpty()){
            return false;
        }
        return client.get().getPassword().equals(signInForm.getPassword())
                && client.get().getState().equals(Client.State.CONFIRMED);
    }
}
