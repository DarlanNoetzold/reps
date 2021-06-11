package tech.noetzold.reps.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tech.noetzold.reps.dto.RequisicaoNovoObjrep;
import tech.noetzold.reps.model.Objrep;
import tech.noetzold.reps.model.User;
import tech.noetzold.reps.repository.ObjrepRepository;
import tech.noetzold.reps.repository.UserRepository;

@Controller
@RequestMapping("objrep")
public class ObjrepController {
	
	@Autowired
	private ObjrepRepository objrepRepository;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("formulario")
	public String formulario(RequisicaoNovoObjrep requisicao) {
		return "objrep/formulario";
	}
	
	@GetMapping("remover/{id}")
    public String remover(@PathVariable("id") Long id) {
		objrepRepository.deleteById(id);
        return "redirect:/home";
    }
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoObjrep requisicao, BindingResult result) {
		if(result.hasErrors()) {
			return "objrep/formulario";
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		User usuario = userRepository.findByUsername(username);
		Objrep objrep = requisicao.toObjrep();
		objrep.setUser(usuario);
		objrepRepository.save(objrep);
		return "redirect:/home";
	}
}