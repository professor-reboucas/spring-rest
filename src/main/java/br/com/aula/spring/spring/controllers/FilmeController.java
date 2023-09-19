package br.com.aula.spring.spring.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import br.com.aula.spring.spring.repositories.FilmeRepository;
import br.com.aula.spring.spring.dto.FilmeDto;
import br.com.aula.spring.spring.models.FilmeModel;

@RestController
public class FilmeController {

	@Autowired
	FilmeRepository filmeRepository;
	
	@PostMapping("/filmes")
	public ResponseEntity<FilmeModel> salvar(@RequestBody @Valid FilmeDto filmeDto) {
		var filmeModel = new FilmeModel();
		BeanUtils.copyProperties(filmeDto, filmeModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(filmeRepository.save(filmeModel));
	}
	
	@GetMapping("/filmes")
	public ResponseEntity<List<FilmeModel>> listar(){
		List<FilmeModel> filmeList = filmeRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(filmeList);
	}
	
	@GetMapping("/filmes/{id}")
	public ResponseEntity<Object> detalhar(@PathVariable(value="id") Integer id){
		Optional<FilmeModel> filme = filmeRepository.findById(id);
		if(filme.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado exibição.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(filme.get());
	}
	
	@DeleteMapping("/filmes/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") Integer id) {
		Optional<FilmeModel> filme = filmeRepository.findById(id);
		if(filme.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado para exclusão.");
		}
		filmeRepository.delete(filme.get());
		return ResponseEntity.status(HttpStatus.OK).body("O Filme foi excluído.");
	}
	
	@PutMapping("/filmes/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable(value="id") Integer id,
													  @RequestBody @Valid FilmeDto filmeDto) {
		Optional<FilmeModel> filme = filmeRepository.findById(id);
		if(filme.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado para edição.");
		}
		var filmeModel = filme.get();
		BeanUtils.copyProperties(filmeDto, filmeModel);
		return ResponseEntity.status(HttpStatus.OK).body(filmeRepository.save(filmeModel));
	}
}
