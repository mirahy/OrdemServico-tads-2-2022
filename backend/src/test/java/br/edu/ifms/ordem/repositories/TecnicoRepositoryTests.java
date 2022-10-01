package br.edu.ifms.ordem.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import br.edu.ifms.ordem.entities.Tecnico;
import br.edu.ifms.ordem.tests.Factory;

@DataJpaTest
public class TecnicoRepositoryTests {
	
	@Autowired
	private TecnicoRepository repository;
	private long idExistente;
	private long idInexistente;
	
	@BeforeEach
	void setUp() throws Exception {
		idExistente = 1L;
		idInexistente = 10L;
	}
	
	/*
	 * Acesso a Dados
	 * CRUD - Create, Read, Update and Delete
	 */
	
	/**
	 * SAVE
	 * deveria SALVAR REGISTRO [quando O ID FOR NULO]
	 * saveDeveriaSalvarRegistroQuandoIdForNulo
	 */
	
	@Test
	public void saveDeveriaSalvarRegistroQuandoIdForNulo() {
		Tecnico tecnico = Factory.novoTecnico();
		tecnico.setId(null);
		
		tecnico = repository.save(tecnico);
		
		Assertions.assertNotNull(tecnico.getId());
	}
	
	
	/**
	 * DELETE
	 * deveria EXCLUIR REGISTRO [quando O ID EXISTIR]
	 */
	@Test
	public void deleteDeveriaExcluirRegistroQuandoIdExistir() {
		//Act
		repository.deleteById(idExistente);
		
		//Assert
		Optional<Tecnico> resultado; 
		resultado = repository.findById(idExistente);
		Assertions.assertFalse(resultado.isPresent());
	}
	
	
	/**
	 * DELETE
	 * deveria LANÇAR EXEÇÃO [quando O ID NÃO EXISTIR]
	 * deleteDeveriaLançarEmptyResultDataAccessExceptionQuandoIdNaoExixtir
	 */
	@Test
	public void deleteDeveriaLançarEmptyResultDataAccessExceptionQuandoIdNaoExixtir() {
		
		Assertions.assertThrows(EmptyResultDataAccessException.class, () ->{
			repository.deleteById(idInexistente);
		});
	}
	
	
	/**
	 * findById 
	 * deveria RETRONAR um OPTIONAL<Tecnico> [NÃO VAZIO quando o ID EXISTIR]
	 * findByIdDeveriaRetronarOptionalTecnicoNaoVazioQuandoIdExistir
	 */
	@Test
	public void findByIdDeveriaRetronarOptionalTecnicoNaoVazioQuandoIdExistir() {
		
		//Assert
		Optional<Tecnico> resultado;
		resultado = repository.findById(1L);
		Assertions.assertNotNull(resultado.isPresent());
	
	}
	
	/**
	 * findById 
	 * deveria RETRONAR um OPTIONAL<Tecnico> [VAZIO quando o ID NÃO EXISTIR]
	 * findByIdDeveriaRetronarOptionalTecnicoVazioQuandoIdNaoExistir
	 */
	@Test
	public void findByIdDeveriaRetronarOptionalTecnicoVazioQuandoIdNaoExistir() {
		
		//Assert
		Optional<Tecnico> resultado;
		resultado = repository.findById(20L);
		Assertions.assertFalse(resultado.isPresent());
	
	}
	
	
	


}
