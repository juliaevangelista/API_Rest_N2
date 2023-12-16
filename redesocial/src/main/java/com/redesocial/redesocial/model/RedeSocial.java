package com.redesocial.redesocial.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="redesocial")
public class RedeSocial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributos para representar um usuário
    private String nomeusuario;
    private String senha; // Adicione um campo de senha para autenticação, se necessário

    // Atributos para representar uma postagem
    private String textopostagem;

    // Atributos para representar uma curtida
    private int numerocurtidas;

    // Atributos para representar amigos (pode ser uma lista de IDs de usuários, por exemplo)
    // Ou você pode ter uma tabela separada para armazenar as relações de amizade
    // private List<Long> amigos;
    
    public RedeSocial(RedeSocialDados dados) {
        this.nomeusuario = dados.nomeusuario();
        this.senha = dados.senha();
        this.textopostagem = dados.textopostagem();
        this.numerocurtidas = dados.numerocurtidas();
    }


    public RedeSocial() {}
    public void atualizaRedeSocial(RedeSocialUpdateDados dados){
        this.nomeusuario = dados.nomeusuario();
        this.senha = dados.senha();
        this.textopostagem = dados.textopostagem();
        this.numerocurtidas = dados.numerocurtidas();
    }


    @Override
    public String toString() {
        return "RedeSocial [id=" + id + ", nomeusuario=" + nomeusuario + ", textopostagem=" + textopostagem
                + ", numerocurtidas=" + numerocurtidas + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeusuario() {
        return nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTextopostagem() {
        return textopostagem;
    }

    public void setTextopostagem(String textopostagem) {
        this.textopostagem = textopostagem;
    }

    public int getNumerocurtidas() {
        return numerocurtidas;
    }

    public void setNumerocurtidas(int numerocurtidas) {
        this.numerocurtidas = numerocurtidas;
    }
}

