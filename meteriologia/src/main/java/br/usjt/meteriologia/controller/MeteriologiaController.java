package br.usjt.meteriologia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.meteriologia.model.Meteriologia;
import br.usjt.meteriologia.service.MeteriologiaService;

@Controller
public class MeteriologiaController {
	
	@Autowired
	public MeteriologiaService meteriologiaService;
	
	
	@GetMapping("/meteriologia")
	public ModelAndView listarMeteriologia() {
		
		ModelAndView mv = new ModelAndView("lista_meteriologia");
		List<Meteriologia> meteriologias = meteriologiaService.listarTodos();
		mv.addObject("meteriologias", meteriologias);
		mv.addObject(new Meteriologia());
		return mv;
	}
	
	@PostMapping("/meteriologia")
	public String salvar(Meteriologia meteriologia) {
		meteriologiaService.salvar(meteriologia);
		return "redirect:/meteriologia";
	}
}
