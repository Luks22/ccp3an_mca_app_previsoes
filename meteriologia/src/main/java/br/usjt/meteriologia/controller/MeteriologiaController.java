package br.usjt.meteriologia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.meteriologia.model.Meteriologia;
import br.usjt.meteriologia.repository.MeteriologiaRepository;

@Controller
public class MeteriologiaController {
	
	@Autowired
	public MeteriologiaRepository meteriologiaRepo;
	
	
	@GetMapping("/meteriologia")
	public ModelAndView listarMeteriologia() {
		
		ModelAndView mv = new ModelAndView("lista_meteriologia");
		List<Meteriologia> meteriologia = meteriologiaRepo.findAll();
		mv.addObject("meteriologia", meteriologia);
		return mv;
	}
}
