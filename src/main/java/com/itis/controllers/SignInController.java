package com.itis.controllers;

import com.itis.dto.SignInForm;
import com.itis.models.Client;
import com.itis.repositories.ClientRepository;
import com.itis.service.SignInService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
@RequestMapping("/sign-in")
public class SignInController{
    private SignInService signInService;
    private ClientRepository clientRepository;

    @GetMapping
    public String getPage(){
        return "sign-in";
    }

    @PostMapping
    public String signIn(SignInForm signInForm, Model model, HttpSession session){
        if(signInService.signIn(signInForm)){
            Client client = clientRepository.getClientByEmail(signInForm.getEmail());
            model.addAttribute("user", client);
            session.setAttribute("client", client);
            return "profile";
        }
        return "sign-in";
    }
}
