package com.itis.service;

import com.itis.dto.SignUpForm;
import com.itis.models.Client;
import com.itis.repositories.ClientRepository;
import com.itis.utils.MailsUtil;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SignUpServiceImpl implements SignUpService {
    private final ClientRepository clientRepository;

    private final MailsUtil mailsUtil;

    @Override
    public void signUp(SignUpForm signUpForm) {
        Client client = Client.builder()
                .email(signUpForm.getEmail())
                .firstName(signUpForm.getFirstName())
                .lastName(signUpForm.getLastName())
                .password(signUpForm.getPassword())
                .confirmCode(UUID.randomUUID().toString())
                .state(Client.State.NOT_CONFIRMED)
                .build();
        clientRepository.save(client);
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", client.getFirstName() + " " + client.getLastName());
        data.put("confirmCode", client.getConfirmCode());

        mailsUtil.sendMail(signUpForm.getEmail(), "Confirmation", "confirm-mail.ftl", data);
    }
}
