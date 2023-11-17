package com.example.Aula.entities;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table( name = "tb_compromisso")
public class Compromisso {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50, nullable = false)
	private String localcomp;
	@Column(length = 12, nullable = false)
	private String contato;
	@Column(length = 100, nullable = false)
	private String datacomp;
	@Column(length = 100, nullable = false)
	private String hora;
	@Column(length = 100, nullable = false)
	private String status;
	@Column(length = 100, nullable = false)
	private String idcontato;
	
	public int getId() {
		return id;
	}







	public void setId(int id) {
		this.id = id;
	}







	public String getLocalcomp() {
		return localcomp;
	}







	public void setLocalcomp(String localcomp) {
		this.localcomp = localcomp;
	}







	public String getContato() {
		return contato;
	}







	public void setContato(String contato) {
		this.contato = contato;
	}







	public String getDatacomp() {
		return datacomp;
	}







	public void setDatacomp(String datacomp) {
		this.datacomp = datacomp;
	}







	public String getHora() {
		return hora;
	}







	public void setHora(String hora) {
		this.hora = hora;
	}







	public String getStatus() {
		return status;
	}







	public void setStatus(String status) {
		this.status = status;
	}







	public String getIdcontato() {
		return idcontato;
	}







	public void setIdcontato(String idcontato) {
		this.idcontato = idcontato;
	}



	public Compromisso(int id, String localcomp, String contato, String datacomp, String hora, String status,
			String idcontato) {
		super();
		this.id = id;
		this.localcomp = localcomp;
		this.contato = contato;
		this.datacomp = datacomp;
		this.hora = hora;
		this.status = status;
		this.idcontato = idcontato;
	}

	public Compromisso() {

	}

}