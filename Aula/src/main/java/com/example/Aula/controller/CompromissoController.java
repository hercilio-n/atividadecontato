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

import com.example.Aula.entities.Compromisso;
import com.example.Aula.repository.CompromissoRepository;

@RestController
@RequestMapping("/contatos")
public class CompromissoController {
	@Autowired
	CompromissoRepository repo;
	
	@GetMapping()
	public ResponseEntity<List<Compromisso>> getCompromissos() {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}
		
	@PostMapping()
	public ResponseEntity<Compromisso> inserirCompromisso(@RequestBody Compromisso contato) {
		Compromisso ct = repo.save(contato);
		return ResponseEntity.status(HttpStatus.CREATED).body(ct);
	}
	
	@PutMapping("/{idcontato}")
	public ResponseEntity<Compromisso> alterarCompromisso(@PathVariable("idcontato") Long idcontato, 
			@RequestBody Compromisso contato) {
		Optional<Compromisso> opCompromisso = repo.findById(idcontato);
		try {
			Compromisso ct = opCompromisso.get();		
			ct.setNome(contato.getNome());
			ct.setEmail(contato.getEmail());
			repo.save(ct);
			return ResponseEntity.status(HttpStatus.OK).body(ct);
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Compromisso> getUmCompromisso(@PathVariable("id") long id) {
		Optional<Compromisso> opCompromisso = repo.findById(id);
		try {
			Compromisso ct = opCompromisso.get();		
			return ResponseEntity.status(HttpStatus.OK).body(ct);
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Compromisso> excluirUmCompromisso(@PathVariable("id") long id) {
		Optional<Compromisso> opCompromisso = repo.findById(id);
		try {
			Compromisso ct = opCompromisso.get();	
			repo.delete(ct);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
}