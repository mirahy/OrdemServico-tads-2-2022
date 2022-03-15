package br.edu.ifms.ordem.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.ordem.entities.Tecnico;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {

	@GetMapping
	public ResponseEntity<List<Tecnico>> findAll(){
		List<Tecnico> list = new ArrayList<>();
		list.add(new Tecnico(1L, "João da Silva", "(67) 7878787", "joao@gmail.com", "123"));
		list.add(new Tecnico(1L, "Maria Celeste", "(67) 4324324", "maria@gmail.com", "123"));
		return ResponseEntity.ok().body(list);
	}
}
