package br.com.vertigo.pessoas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vertigo.pessoas.model.Pessoa;
import br.com.vertigo.pessoas.repository.PessoaRepository;

@Service
public class PessoaServiceImpl implements PessoaService {
   
	@Autowired
    private PessoaRepository pessoaRepository;
    

    @Override
    public void save(Pessoa pessoa) {
    	pessoaRepository.save(pessoa);
    }

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }
    
    @Override
    public Pessoa findByNome(String nome) {
        return pessoaRepository.findByNome(nome);
    }
    

}
