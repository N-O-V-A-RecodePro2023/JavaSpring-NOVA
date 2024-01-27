package com.example.javaspring.controller;

import org.springframework.ui.Model;
import com.example.javaspring.model.Empresa;
import com.example.javaspring.services.EmpresaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    //SALVA O CADASTRO E REDIRECIONA PARA O PERFIL DA EMPRESA
    @PostMapping("/cadastro")
    public String saveEmpresa(@ModelAttribute("empresa") Empresa empresa) {
        Empresa savedEmpresa = empresaService.saveEmpresa(empresa);
        return "redirect:/empresa/empresaPerfil/" + savedEmpresa.getId();
    }

    //MOSTRA O PERFIL DA EMPRESA
    @GetMapping("/empresaPerfil/{idEmpresa}")
    private String showEmpresaPerfil(@PathVariable("idEmpresa") Integer idEmpresa, Model model) {
        Empresa empresa = empresaService.getEmpresaById(idEmpresa);
        model.addAttribute("empresa", empresa);
        return "empresaPerfil";
    }

    //MOSTRA O FORMULÁRIO DE CADASTRO
    @GetMapping("/novo")
    public String showFormForAdd(Model model) {
        Empresa empresa = new Empresa();
        model.addAttribute("empresa", empresa);
        return "cadastroEmpresa";
    }

    @GetMapping("/editar/{idEmpresa}")
    public String showFormForUpdate(@PathVariable Integer idEmpresa, Model model) {
        Empresa empresa = empresaService.getEmpresaById(idEmpresa);
        model.addAttribute("empresa", empresa);
        return "editarEmpresa";
    }

    @PostMapping("/editar/{idEmpresa}")
    public String updateEmpresa(@PathVariable Integer idEmpresa, @ModelAttribute("empresa") Empresa empresa) {
        empresaService.updateEmpresa(idEmpresa, empresa);
        return "redirect:/empresa/empresaPerfil/" + idEmpresa;
    }

    @GetMapping("/deletar/{idEmpresa}")
    public String deleteEmpresa(@PathVariable Integer idEmpresa) {
        empresaService.deleteEmpresa(idEmpresa);
        return "redirect:/index.html";
    }
}

















