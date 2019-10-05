package dev.fujioka.java.avancado.web.web.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.fujioka.java.avancado.web.domain.Avaliacao;
import dev.fujioka.java.avancado.web.service.AvaliacaoService;

@RestController
@RequestMapping("/api")
public class AvaliacaoResource {
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@GetMapping("/avaliacao")
	public List<Avaliacao> getAvaliacoes() {
		return avaliacaoService.findAll();
	}
	
	@PostMapping("/avaliacao")
    public ResponseEntity<Avaliacao>
    save(@Valid @RequestBody Avaliacao avaliacao) {
		avaliacaoService.save(avaliacao);
        return ResponseEntity.ok(avaliacao);
    }

}
