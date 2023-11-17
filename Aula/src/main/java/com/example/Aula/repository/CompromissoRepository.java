package com.example.Aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Aula.entities.Contato;

@Repository
public interface CompromissoRepository extends JpaRepository<Contato, Long>{

}