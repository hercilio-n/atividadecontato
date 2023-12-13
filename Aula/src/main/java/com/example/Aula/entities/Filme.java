package com.example.Aula.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table( name = "tb_filmes")
public class Filme {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50, nullable = false)
	private String nome;
	@Column(length = 100, nullable = false)
	private String anolan;
	@Column(length = 100, nullable = false)
	private String diretor;
	@Column(length = 100, nullable = false)
	private String sinopse;
	@Column(length = 100, nullable = false)
	private String genero;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAnolan() {
		return anolan;
	}
	public void setAnolan(String anolan) {
		this.anolan = anolan;
	}
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public Filme(int id, String nome, String anolan, String diretor, String sinopse, String genero) {
		super();
		this.id = id;
		this.nome = nome;
		this.anolan = anolan;
		this.diretor = diretor;
		this.sinopse = sinopse;
		this.genero = genero;
	}
	
	public Filme() {

	}
	
	

}