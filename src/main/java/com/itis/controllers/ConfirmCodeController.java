package com.itis.controllers;

import com.itis.service.ConfirmCodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/confirm")
public class ConfirmCodeController {

    private final ConfirmCodeService codeService;
    @GetMapping("/{confirm-code}")
    public String confirm(@PathVariable("confirm-code") String code, Long userId){
        if(codeService.validateUser(code)){
            return "redirect:/confirm/success";
        }
        else return "redirect:/confirm/failure";
    }

    @GetMapping("/success")
    public String success(){
        return "confirmSuccess";
    }

    @GetMapping("/failure")
    public String failure(){
        return "confirmFailure";
    }
}
