package com.example.javaspring.controller;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.example.javaspring.model.Candidatura;
import com.example.javaspring.services.CandidaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/candidatura")
public class CandidaturaController {

    @Autowired
    private CandidaturaService candidaturaService;

    //ver a lista de candidaturas
    @GetMapping("/candidaturas")
    public String showCandidaturas(Model model){
        List<Candidatura> candidatura = candidaturaService.getAllCandidaturas();
        model.addAttribute("candidatura", candidatura);
        return "candidaturas";
    }

    //Deletar candidatura
    @GetMapping("/deletar/{idCandidatura}")
    public String deleteCandidatura(@PathVariable Integer idCandidatura){
        candidaturaService.deleteCandidatura(idCandidatura);
        return "redirect:home.html";
    }
}
