package com.example.Aula.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Aula.entities.Filme;
import com.example.Aula.repository.FilmeRepository;

import jakarta.persistence.Column;

@RestController
@RequestMapping("/Filmes")
public class FilmeController {
	@Autowired
	FilmeRepository repo;
	
	@GetMapping()
	public ResponseEntity<List<Filme>> getFilmes() {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}
		
	@PostMapping("/cadastrar")
	public ResponseEntity<Filme> inserirFilme(@RequestBody Filme Filme) {
		Filme ct = repo.save(Filme);
		return ResponseEntity.status(HttpStatus.CREATED).body(ct);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Filme> alterarFilme(@PathVariable("id") Long idFilme, 
			@RequestBody Filme Filme) {
		Optional<Filme> opFilme = repo.findById(idFilme);
		try {
			Filme ct = opFilme.get();		
			ct.setNome(Filme.getNome());
			ct.setAnolan(Filme.getAnolan());
			ct.setDiretor(Filme.getDiretor());
			ct.setSinopse(Filme.getSinopse());
			ct.setGenero(Filme.getGenero());
			repo.save(ct);
			return ResponseEntity.status(HttpStatus.OK).body(ct);
		}
	
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Filme> getUmFilme(@PathVariable("id") long id) {
		Optional<Filme> opFilme = repo.findById(id);
		try {
			Filme ct = opFilme.get();		
			return ResponseEntity.status(HttpStatus.OK).body(ct);
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Filme> excluirUmFilme(@PathVariable("id") long id) {
		Optional<Filme> opFilme = repo.findById(id);
		try {
			Filme ct = opFilme.get();	
			repo.delete(ct);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
}