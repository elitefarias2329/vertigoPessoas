package br.com.vertigo.pessoas.service;

import java.util.List;

import br.com.vertigo.pessoas.model.Pessoa;

public interface PessoaService {
    
	void save(Pessoa pessoa);

	List<Pessoa> findAll();
	
	Pessoa findByNome(String nome);
}
