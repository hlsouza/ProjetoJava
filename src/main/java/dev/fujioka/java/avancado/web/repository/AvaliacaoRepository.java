package dev.fujioka.java.avancado.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.fujioka.java.avancado.web.domain.Avaliacao;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

	public List<Avaliacao> findAvaliacaoByProfessor(String professor);
	
	public List<Avaliacao> findAvaliacaoByProfessorAndDisciplina(String professor, String disciplina);
	
	public List<Avaliacao> findAvaliacaoByDisciplina(String disciplina);
	
	//tem que especificar a query porque mudou o padrao do nome do metodo (em ingles)
	@Query("Select a from Avaliacao a where a.professor = :professor")
	public List<Avaliacao> buscaAvaliacaoPorProfessor(@Param("professor") String professor);
	
}
