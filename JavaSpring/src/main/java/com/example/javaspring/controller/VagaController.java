package com.example.javaspring.controller;

import com.example.javaspring.model.Empresa;
import org.springframework.ui.Model;

import com.example.javaspring.model.Vaga;

import com.example.javaspring.services.VagaService;
import com.example.javaspring.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @Autowired
    private EmpresaService empresaService;

    private Empresa savedEmpresa;

    //Persistência
    @PostMapping("/cadastro")
    public String saveVaga(@ModelAttribute ("vaga") Vaga vaga){
        vaga.setEmpresa(this.savedEmpresa);
        Vaga savedVaga = vagaService.saveVaga(vaga);

        return "redirect:/vagas/vagas";
    } 

    //Ver a vaga por id
    @GetMapping("/vaga/{idVaga}")
    public String showVaga(@PathVariable("idVaga") Integer idVaga, Model model){
        Vaga vaga =  vagaService.getVagaById(idVaga);
        model.addAttribute("vaga", vaga);
        return "vagas";
    }

    @GetMapping("/novo/{idEmpresa}")
    public String showFormForAdd(Model model, @PathVariable ("idEmpresa") Integer idEmpresa){
        Vaga vaga = new Vaga();
        this.savedEmpresa = empresaService.getEmpresaById(idEmpresa);
//        vaga.setEmpresa(empresa);
        model.addAttribute("vaga", vaga);
        return "cadastroVaga";
    }

    //ver a lista de todas as vagas
    @GetMapping("/vagas")
    public String showVagas(Model model){
        List<Vaga> vaga = vagaService.getAllVagas();
        model.addAttribute("vagas", vaga);
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
        return "redirect:/vagas/vaga" + idVaga;
    }

    //Deletar vaga
    @GetMapping("/deletar/{idVaga}")
    public String deleteVaga(@PathVariable Integer idVaga){
        vagaService.deleteVaga(idVaga);
        return "redirect:/index.html";
    }
}
