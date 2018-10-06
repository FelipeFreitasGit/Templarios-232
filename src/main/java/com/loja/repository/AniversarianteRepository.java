package com.loja.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loja.models.Aniversariante;

public interface AniversarianteRepository extends JpaRepository<Aniversariante, Long>{
	
	@Query("SELECT a FROM Aniversariante a WHERE month(a.dataAniversario) = month(now())")
	List<Aniversariante> findAniversarianteByDataAniversario(Date data);
	
}
