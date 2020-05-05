package com.usjt.previsoes.resource;

import java.net.URI;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.usjt.previsoes.model.Cidade;
import com.usjt.previsoes.repository.CidadeRepository;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {
	
	@PersistenceContext 
	EntityManager manager;
	
	@Autowired
	private CidadeRepository cidadeRepo;

	@GetMapping("/lista")
	public List<Cidade> todosOsLivros() {
		return cidadeRepo.findAll();
	}

	@PostMapping("/salvar")
	public ResponseEntity<Cidade> salvar(@RequestBody Map<String, String> params, HttpServletResponse response) {

		Cidade cidade = new Cidade();
		cidade.setNome(params.get("nome"));
		cidade.setLatitude(Double.parseDouble(params.get("latitude")));
		cidade.setLongitude(Double.parseDouble(params.get("longitude")));

		Cidade c = cidadeRepo.save(cidade);
		URI uri = ServletUriComponentsBuilder.

				fromCurrentServletMapping().path("/{id}").buildAndExpand(c.getId()).toUri();
		return ResponseEntity.created(uri).body(c);
	}

	@GetMapping("/{id}")
	public Cidade buscarPeloId(@PathVariable Long id) {
		return cidadeRepo.getOne(id);
	}

	@GetMapping("/latitude={lat}/longitude={lon}")
	public Cidade buscarPorLatLon(@PathVariable(value = "lat") String latitude, @PathVariable(value = "lon") String longitude) {
		
		double lat = Double.parseDouble(latitude);
		double lon = Double.parseDouble(longitude);
		
		List<Cidade> cidades = cidadeRepo.findAll();
		Cidade cidade = new Cidade();
		
		for(Cidade c : cidades) {
			if(c.getLatitude() == lat && c.getLongitude() == lon) {
				cidade = c;
			}
		}
		
		return cidade;
	}
	
	@GetMapping("/letra={letra}")
	public List<Cidade> buscarPorLetra(@PathVariable(value = "letra") char letra) {
		Query query = manager.createQuery("select c from Cidade c where c.nome like :letra");
		query.setParameter("letra", letra+"%");
		return query.getResultList();
	}
	
	
	
}