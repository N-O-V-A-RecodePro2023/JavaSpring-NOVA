package com.example.javaspring.controller;

import org.springframework.ui.Model;
import com.example.javaspring.model.Candidato;
import com.example.javaspring.services.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/candidato")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

        //Persistencia
        @PostMapping("/cadastro")
        public String saveCandidato(@ModelAttribute ("candidato") Candidato candidato){
            Candidato savedCandidato = candidatoService.saveCandidato(candidato);
            return "redirect:/candidato/candidato_perfil/" + savedCandidato.getId();
        }

        @GetMapping("/candidato_perfil/{idCandidato}")
        public String showCandidatoPerfil(@PathVariable("idCandidato") Integer idCandidato, Model model) {
            Candidato candidato = candidatoService.getCandidatoById(idCandidato);
            model.addAttribute("candidato", candidato);
            return "candidato_perfil";
        }

        //Mostrar o form de novo cadastro
        @GetMapping("/novo")
        public String showFormForAdd(Model model){
            Candidato candidato = new Candidato();
            model.addAttribute("candidato", candidato);
            return "cadastro_candidato";
        }

    //Mostrar o form de edição
    @GetMapping("/editar/{idCandidato}")
    public String showFormForUpdate(@PathVariable Integer idCandidato, Model model){
        Candidato candidato = candidatoService.getCandidatoById(idCandidato);
        model.addAttribute("candidato", candidato);
        return "editar_candidato";
    }

    //Mostrar o form de edição
    @PostMapping ("/editar/{idCandidato}")
    public String updateCandidato(@PathVariable Integer idCandidato, @ModelAttribute ("candidato") Candidato candidato){
        candidatoService.updateCandidato(idCandidato, candidato);
        return "redirect:/candidato/candidato_perfil/" + idCandidato;
    }

    @GetMapping("/deletar/{idCandidato}")
    public String deleteCandidato(@PathVariable Integer idCandidato){
        candidatoService.deleteCandidato(idCandidato);
        return "redirect:/home.html";
    }

}