package br.com.vertigo.pessoas.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.vertigo.pessoas.model.Pessoa;
import br.com.vertigo.pessoas.service.PessoaService;

@Controller
public class PessoaController {
   
	@Autowired
    private PessoaService pessoaService;


    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
    	model.addAttribute("pessoa", new Pessoa()); 
    	model.addAttribute("listaPessoas", pessoaService.findAll());
        return "welcome";
    }
    
    
    @RequestMapping(value = "/pessoaView/salvar", method = RequestMethod.POST)
    public String salvar(@Valid @ModelAttribute("pessoa")Pessoa pessoa, BindingResult result, ModelMap model) {
        
    	if(isPessoaValida(pessoa, result)) {
    		pessoaService.save(pessoa);
    		model.addAttribute("sucesso", "A pessoa foi cadastrada com sucesso!");
    	}
    	
    	model.addAttribute("listaPessoas", pessoaService.findAll());
        return "welcome";
    }
    
    
    
    private boolean isPessoaValida(Pessoa pessoa, BindingResult result) {
    	
    	boolean isPessoaValida = true; 
    	
    	if(StringUtils.isEmpty(pessoa.getNome())){
    		result.rejectValue("nome", "error.nomeIsEmpty", "O Campo Nome não pode estar vazio!");
    		isPessoaValida = false;
    	}
    	
    	if(StringUtils.isEmpty(pessoa.getSobrenome())){
    		result.rejectValue("sobrenome", "error.sobrenomeIsEmpty", "O Campo Sobrenome não pode estar vazio!");
    		isPessoaValida = false;
    	}
    	
    	return isPessoaValida;
    	
    }
    
}
