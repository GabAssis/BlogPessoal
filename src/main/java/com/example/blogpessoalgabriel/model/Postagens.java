package com.example.blogpessoalgabriel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity//Anotação que implica que essa classe será uma Model
@Table(name = "tb_postagens")
public class Postagens {

    @Id//primary key(id)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Atributo obrigatório")
    @Size(min = 2,max = 255)
    private String titulo;

    @NotBlank(message = "Atributo obrigatório")
    @Size(min = 10,max = 1000)
    private String texto;

    @UpdateTimestamp
    private LocalDateTime dataPostagem;

    @ManyToOne
    @JsonIgnoreProperties("postagens")
    private Tema tema;

    @ManyToOne
    @JsonIgnoreProperties("postagens")
    private Usuario usuario;

    //GET AND SET
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(LocalDateTime dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
}
