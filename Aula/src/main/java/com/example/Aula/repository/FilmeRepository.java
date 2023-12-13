package com.example.Aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Aula.entities.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long>{

}