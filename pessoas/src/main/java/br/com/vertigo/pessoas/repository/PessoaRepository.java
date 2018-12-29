package br.com.vertigo.pessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vertigo.pessoas.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
	Pessoa findByNome(String nome);
}
