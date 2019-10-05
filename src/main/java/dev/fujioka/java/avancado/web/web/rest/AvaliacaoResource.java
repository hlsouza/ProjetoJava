package dev.fujioka.java.avancado.web.web.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/avaliacao/{id}")
	public ResponseEntity<Avaliacao> getAvaliacoesById(@PathVariable Long id) {
		Optional<Avaliacao> retorno = avaliacaoService.findById(id);
		
		if(retorno.isPresent())
			return ResponseEntity.of(retorno);
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/avaliacao/{professor}/{disciplina}")
	public ResponseEntity<List<Avaliacao>> getAvaliacoesById(@PathVariable String professor, @PathVariable String disciplina) {
		
	Optional<List<Avaliacao>> retorno = Optional.ofNullable(avaliacaoService.findAvaliacaoByProfessorAndDisciplina(professor, disciplina));
		
		if(retorno.isPresent() && !retorno.get().isEmpty())
			return ResponseEntity.of(retorno);
		
		return ResponseEntity.notFound().build();
	}	
	
	@GetMapping("/avaliacao/professor/{professor}")
	public ResponseEntity<List<Avaliacao>> getAvaliacoesByProfessor(@PathVariable String professor) {
		
	Optional<List<Avaliacao>> retorno = Optional.ofNullable(avaliacaoService.findAvaliacaoByProfessor(professor));
		
		if(retorno.isPresent() && !retorno.get().isEmpty())
			return ResponseEntity.of(retorno);
		
		return ResponseEntity.notFound().build();
	}	
	
	//colocou "/disciplina" na rota para nao dar erro "ambiguous" com a rota acima
	@GetMapping("/avaliacao/disciplina/{disciplina}")
	public ResponseEntity<List<Avaliacao>> getAvaliacoesByDisciplina(@PathVariable String disciplina) {
		
	Optional<List<Avaliacao>> retorno = Optional.ofNullable(avaliacaoService.findAvaliacaoByDisciplina(disciplina));
		
		if(retorno.isPresent() && !retorno.get().isEmpty())
			return ResponseEntity.of(retorno);
		
		return ResponseEntity.notFound().build();
	}	
	
	@PostMapping("/avaliacao")
    public ResponseEntity<Avaliacao>
    save(@Valid @RequestBody Avaliacao avaliacao) {
		avaliacaoService.save(avaliacao);
        return ResponseEntity.ok(avaliacao);
    }
	
}
