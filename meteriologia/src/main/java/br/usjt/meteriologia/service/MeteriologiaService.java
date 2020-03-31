package br.usjt.meteriologia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.meteriologia.model.Meteriologia;
import br.usjt.meteriologia.model.Relogio;
import br.usjt.meteriologia.repository.MeteriologiaRepository;

@Service
public class MeteriologiaService {

	@Autowired
	private MeteriologiaRepository meteriologiaRepo;
	
	@Autowired
	private Relogio relogio;

	public void salvar(Meteriologia meteriologia) {
		meteriologiaRepo.save(meteriologia);
	}

	public List<Meteriologia> listarTodos() {
		List<Meteriologia> dados = meteriologiaRepo.findAll();
		
		for(Meteriologia meteriologia : dados) {
			meteriologia.setHorario(relogio.horario());
		}
		
		return dados;
	}

}
