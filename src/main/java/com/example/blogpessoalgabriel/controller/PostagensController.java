package com.example.blogpessoalgabriel.controller;


import com.example.blogpessoalgabriel.model.Postagens;
import com.example.blogpessoalgabriel.repository.PostagensRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpLogging;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagensController {

    @Autowired
    private PostagensRepository postagensRepository;

    @GetMapping
    public ResponseEntity<List<Postagens>> getAll() {
        return ResponseEntity.ok(postagensRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagens> getById(@PathVariable Long id) {
        return postagensRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Postagens>> getByTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(postagensRepository.findAllByTituloContainingIgnoreCase(titulo));
    }

    @PostMapping
    public ResponseEntity<Postagens> post(@Valid @RequestBody Postagens postagens) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(postagensRepository.save(postagens));

    }

    @PutMapping
    public ResponseEntity<Postagens> put(@Valid @RequestBody Postagens postagens){
        return postagensRepository.findById(postagens.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.OK)
                .body(postagensRepository.save(postagens)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }



    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Postagens> postagens = postagensRepository.findById(id);
        if(postagens.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    postagensRepository.deleteById(id);
    }


}
