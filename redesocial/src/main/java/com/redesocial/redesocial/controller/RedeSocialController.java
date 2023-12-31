package com.redesocial.redesocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.redesocial.redesocial.model.RedeSocial;
import com.redesocial.redesocial.model.RedeSocialDados;
import com.redesocial.redesocial.model.RedeSocialRepository;
import com.redesocial.redesocial.model.RedeSocialUpdateDados;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/redesocial")
public class RedeSocialController {

    @Autowired
    private RedeSocialRepository repository;

    @GetMapping("/formulario")
    public String mostrarFormularioCriar(Long id, Model model) {
        if (id != null) {
            RedeSocial redeSocial = repository.findById(id).orElse(null);
            model.addAttribute("redeSocial", redeSocial);
        }
        return "redesocial/formulario";
    }

    @GetMapping
    public String loadRedeSocialList(Model model) {
        model.addAttribute("redesocial", repository.findAll());
        return "redesocial/listar";
    }

    @PostMapping("/formulario")
    @Transactional
    public String registrarRedeSocial(RedeSocialDados dados) {
        RedeSocial redeSocial = new RedeSocial(dados);
        repository.save(redeSocial);
        return "redirect:/redesocial";
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String deletarRedeSocial(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/redesocial";
    }

    @PutMapping("/{id}")
    @Transactional
    public String atualizaRedeSocial(@PathVariable Long id, RedeSocialUpdateDados dados) {
        RedeSocial redeSocial = repository.findById(id).orElse(null);
        if (redeSocial != null) {
            redeSocial.atualizaRedeSocial(dados);
        }
        return "redirect:/redesocial";
    }
}
