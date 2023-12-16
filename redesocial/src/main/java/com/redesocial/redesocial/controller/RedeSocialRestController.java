package com.redesocial.redesocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redesocial.redesocial.model.RedeSocial;
import com.redesocial.redesocial.model.RedeSocialRepository;

@RestController
@RequestMapping("/api/redessocial")
public class RedeSocialRestController {

    @Autowired
    private RedeSocialRepository redeSocialRepository;

    @GetMapping
    public List<RedeSocial> getAllRedesSociais() {
        return redeSocialRepository.findAll();
    }

    @GetMapping("/{id}")
    public RedeSocial getRedeSocialById(@PathVariable Long id) {
        return redeSocialRepository.findById(id).orElse(null);
    }

    @PostMapping
    public RedeSocial createRedeSocial(@RequestBody RedeSocial redeSocial) {
        return redeSocialRepository.save(redeSocial);
    }

    @PutMapping("/{id}")
    public RedeSocial updateRedeSocial(@PathVariable Long id, @RequestBody RedeSocial redeSocial) {
        if (redeSocialRepository.existsById(id)) {
            redeSocial.setId(id);
            return redeSocialRepository.save(redeSocial);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteRedeSocial(@PathVariable Long id) {
        redeSocialRepository.deleteById(id);
    }
}
