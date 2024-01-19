package com.example.javaspring.controller;

import org.springframework.ui.Model;
import com.example.javaspring.model.Vaga;
import com.example.javaspring.services.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaService vagaService;


    //Persistência
    @PostMapping("/cadastro")
    public String saveVaga(@ModelAttribute ("vaga") Vaga vaga){
        Vaga savedVaga = vagaService.saveVaga(vaga);
        return "redirect:/vagas" + savedVaga.getIdVaga();
    }
    //Ver a vaga por id
    @GetMapping("/vaga/{idVaga}")
    public String showVaga(@PathVariable("idVaga") Integer idVaga, Model model){
        Vaga vaga =  vagaService.getVagaById(idVaga);
        model.addAttribute("vaga", vaga);
        return "vaga";
    }

    //ver a lista de todas as vagas
    @GetMapping("/vagas")
    public String showVagas(Model model){
        List<Vaga> vaga = vagaService.getAllVagas();
        model.addAttribute("vaga", vaga);
        return "vagas";
    }

    //Mostrar o form de edição
    @GetMapping("/editar/{idVaga}")
    public String ShowFormUpdate(@PathVariable Integer idVaga, Model model){
        Vaga vaga = vagaService.getVagaById(idVaga);
        model.addAttribute("vaga", vaga);
        return "editar_vaga";
    }

    @PostMapping("/editar/{idVaga}")
    public String updateVaga(@PathVariable Integer idVaga, @ModelAttribute ("vaga") Vaga vaga){
        vagaService.updateVaga(idVaga, vaga);
        return "redirect:/vagas/vaga/" + idVaga;
    }

    //Deletar vaga
    @GetMapping("/deletar/{idVaga}")
    public String deleteVaga(@PathVariable Integer idVaga){
        vagaService.deleteVaga(idVaga);
        return "redirect:/home.html";
    }



}
