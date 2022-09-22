package br.edu.ifms.ordem.tests;

import br.edu.ifms.ordem.dto.TecnicoDTO;
import br.edu.ifms.ordem.entities.Tecnico;

public class Factory {
	public static Tecnico novoTecnico() {
		Tecnico tecnico = new Tecnico(4L, "Mirahy Fonseca", "67 99999-8888", "mirahy.fonseca@gmail.com", "123456789");
		return tecnico;
	}
	
	public static TecnicoDTO novoTecnicoDTO() {
		Tecnico tecnico = novoTecnico();
		return new TecnicoDTO(tecnico);
	}
}
