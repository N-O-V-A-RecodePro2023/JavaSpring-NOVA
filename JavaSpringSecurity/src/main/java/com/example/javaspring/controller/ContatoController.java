package com.example.javaspring.controller;

import org.springframework.ui.Model;
import com.example.javaspring.model.Contato;
import com.example.javaspring.services.ContatoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contato")
public class ContatoController  {

    @Autowired
    private ContatoService contatoService;

    @PostMapping("/cadastro")
    public String saveContato(@ModelAttribute ("contato") Contato contato){
        contatoService.saveContato(contato);
        return "redirect:/home.html";
    }

    @GetMapping("/novo")
    public String showFormForAdd(Model model){
        Contato contato = new Contato();
        model.addAttribute("contato", contato);
        return "contato";
    }


}
