package br.edu.ifms.ordem.dto;

import java.io.Serializable;

import br.edu.ifms.ordem.entities.Setor;

public class SetorDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String sigla;
	private String nome;
	private String email;
	private String telefone;
	private String coordenador;
	
	public SetorDTO() {
		
	}

	public SetorDTO(Long id, String sigla, String nome, String email, String telefone, String coordenador) {
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.coordenador = coordenador;
	}

	public SetorDTO(Setor setor) {
		
		this.id = setor.getId();
		this.sigla = setor.getSigla();
		this.nome = setor.getNome();
		this.email = setor.getEmail();
		this.telefone = setor.getTelefone();
		this.coordenador = setor.getCoordenador();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}
	
	
	
	
	

}
