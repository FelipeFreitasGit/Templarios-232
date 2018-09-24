package com.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.models.Evento;

public interface EventosRepository extends JpaRepository<Evento, Long>{

}
