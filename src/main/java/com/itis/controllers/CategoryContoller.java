package com.itis.controllers;

import com.itis.dto.TypeDto;
import com.itis.repositories.TypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryContoller {

    private TypeRepository typeRepository;

    @GetMapping
    public String getPage(Model model){
        List<TypeDto> types = TypeDto.from(typeRepository.findAll());
        model.addAttribute("types", types);
        return "categories";
    }
}
