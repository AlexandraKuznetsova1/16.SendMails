package com.itis.controllers;

import com.itis.dto.SignUpForm;
import com.itis.service.SignUpService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sign-up")
@AllArgsConstructor
public class SignUpController {
    private SignUpService signUpService;
    @GetMapping
    public String getPage(){
        return "sign-up";
    }

    @PostMapping
    public String signUp(SignUpForm signUpForm){
        signUpService.signUp(signUpForm);
        return "sign-in";
    }
}
