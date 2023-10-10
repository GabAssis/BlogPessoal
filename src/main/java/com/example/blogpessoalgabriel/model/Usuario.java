package com.example.blogpessoalgabriel.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.apache.logging.log4j.message.Message;

import java.util.List;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Atributo Nome é obrigatório")
    private String nome;

    @NotBlank(message = "O Atributo Usuário é obrigatório!")
    @Email(message = "O email deve ser válido!")
    private String usuario;


    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 7, message = "A senha deve ter no mínimo 7 caracteres!")
    private String senha;


    @Size(max = 5000,message = "O link da foto deve ter no máximo 5000 caracteres")
    private String foto;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario",cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("usuario")
    private List<Postagens> postagens;


    //Get and set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
