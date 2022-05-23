package com.itis.repositories;

import com.itis.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client getClientByEmail(String email);

    Optional<Client> getClientByConfirmCode(String code);
}
