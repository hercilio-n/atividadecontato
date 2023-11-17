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

import com.example.Aula.entities.Contato;
import com.example.Aula.repository.ContatoRepository;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
	@Autowired
	ContatoRepository repo;
	
	@GetMapping()
	public ResponseEntity<List<Contato>> getContatos() {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}
		
	@PostMapping()
	public ResponseEntity<Contato> inserirContato(@RequestBody Contato contato) {
		Contato ct = repo.save(contato);
		return ResponseEntity.status(HttpStatus.CREATED).body(ct);
	}
	
	@PutMapping("/{idcontato}")
	public ResponseEntity<Contato> alterarContato(@PathVariable("idcontato") Long idcontato, 
			@RequestBody Contato contato) {
		Optional<Contato> opContato = repo.findById(idcontato);
		try {
			Contato ct = opContato.get();		
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
	public ResponseEntity<Contato> getUmContato(@PathVariable("id") long id) {
		Optional<Contato> opContato = repo.findById(id);
		try {
			Contato ct = opContato.get();		
			return ResponseEntity.status(HttpStatus.OK).body(ct);
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Contato> excluirUmContato(@PathVariable("id") long id) {
		Optional<Contato> opContato = repo.findById(id);
		try {
			Contato ct = opContato.get();	
			repo.delete(ct);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
}