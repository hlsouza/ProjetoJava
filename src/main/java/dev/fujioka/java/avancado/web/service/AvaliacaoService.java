package dev.fujioka.java.avancado.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fujioka.java.avancado.web.domain.Avaliacao;
import dev.fujioka.java.avancado.web.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService implements CrudInterface<Avaliacao> {

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Override
	public List<Avaliacao> findAll() {
		return avaliacaoRepository.findAll();
	}

	@Override
	public Optional<Avaliacao> save(Avaliacao entity) {
		return Optional.ofNullable(avaliacaoRepository.save(entity));
	}

	@Override
	public Optional<Avaliacao> findById(long id) {
		// TODO Auto-generated method stub
		return avaliacaoRepository.findById(id);
	}

	public List<Avaliacao> findAvaliacaoByProfessorAndDisciplina(String professor, String disciplina) {
		return avaliacaoRepository.findAvaliacaoByProfessorAndDisciplina(professor, disciplina);
	}
	
	public List<Avaliacao> findAvaliacaoByProfessor(String professor) {
		return avaliacaoRepository.findAvaliacaoByProfessor(professor);
	}
	
	public List<Avaliacao> findAvaliacaoByDisciplina(String disciplina) {
		return avaliacaoRepository.findAvaliacaoByDisciplina(disciplina);
	}
	
	@Override
	public void delete(Avaliacao entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
