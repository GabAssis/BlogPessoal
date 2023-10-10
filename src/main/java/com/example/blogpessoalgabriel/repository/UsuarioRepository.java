package com.example.blogpessoalgabriel.repository;

import com.example.blogpessoalgabriel.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsuario(String usuario);
}
