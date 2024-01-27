package com.example.javaspring.controller;

import org.springframework.ui.Model;
import com.example.javaspring.model.Candidato;
import com.example.javaspring.services.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/candidato")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

        //Persistencia
        @PostMapping("/cadastro")
        public String saveCandidato(@ModelAttribute ("candidato") Candidato candidato){
            Candidato savedCandidato = candidatoService.saveCandidato(candidato);
            return "redirect:/candidato/candidatoPerfil/" + savedCandidato.getId();
        }

        @GetMapping("/candidatoPerfil/{idCandidato}")
        public String showCandidatoPerfil(@PathVariable("idCandidato") Integer idCandidato, Model model) {
            Candidato candidato = candidatoService.getCandidatoById(idCandidato);
            model.addAttribute("candidato", candidato);
            return "candidatoPerfil";
        }

        //Mostrar o form de novo cadastro
        @GetMapping("/novo")
        public String showFormForAdd(Model model){
            Candidato candidato = new Candidato();
            model.addAttribute("candidato", candidato);
            return "cadastroCandidatos";
        }

    //Mostrar o form de edição
    @GetMapping("/editar/{idCandidato}")
    public String showFormForUpdate(@PathVariable Integer idCandidato, Model model){
        Candidato candidato = candidatoService.getCandidatoById(idCandidato);
        model.addAttribute("candidato", candidato);
        return "editarCandidato";
    }

    //Mostrar o form de edição
    @PostMapping ("/editar/{idCandidato}")
    public String updateCandidato(@PathVariable Integer idCandidato, @ModelAttribute ("candidato") Candidato candidato){
        candidatoService.updateCandidato(idCandidato, candidato);
        return "redirect:/candidato/candidatoPerfil/" + idCandidato;
    }

    @GetMapping("/deletar/{idCandidato}")
    public String deleteCandidato(@PathVariable Integer idCandidato){
        candidatoService.deleteCandidato(idCandidato);
        return "redirect:/index.html";
    }

}