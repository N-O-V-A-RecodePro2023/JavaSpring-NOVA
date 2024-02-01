package com.example.javaspring.controller;

import com.example.javaspring.model.Candidato;
import com.example.javaspring.model.Empresa;
import com.example.javaspring.interfaces.Usuario;
import com.example.javaspring.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("email", "");
        model.addAttribute("senha", "");
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String senha) {
        Usuario usuario = loginService.autenticar(email, senha);

        if (usuario != null) {
            // sucesso no login
            if (usuario instanceof Candidato) {
                return "redirect:/candidato/candidatoPerfil/" + usuario.getId();
            }
            else if (usuario instanceof Empresa) {
                return "redirect:/empresa/empresaPerfil/" + usuario.getId();
            }
        }

        // erro no login
        return "redirect:/login?error=true";
    }
}
















