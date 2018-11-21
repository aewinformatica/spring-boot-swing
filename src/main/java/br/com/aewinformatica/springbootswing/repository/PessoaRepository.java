package br.com.aewinformatica.springbootswing.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.aewinformatica.springbootswing.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long>{
	
	List<Pessoa> findByNome(String nome);

}
