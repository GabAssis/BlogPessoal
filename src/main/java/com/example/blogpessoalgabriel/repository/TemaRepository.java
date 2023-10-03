package com.example.blogpessoalgabriel.repository;

import com.example.blogpessoalgabriel.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TemaRepository extends JpaRepository<Tema,Long> {

    public List<Tema> findAllByDescricaoContainingIgnoreCase(@Param("descricao")String descricao);


}