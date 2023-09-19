package br.com.aula.spring.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.aula.spring.spring.models.FilmeModel;

@Repository
public interface FilmeRepository extends JpaRepository<FilmeModel, Integer>{

}