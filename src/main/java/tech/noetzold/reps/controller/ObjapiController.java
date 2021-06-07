package tech.noetzold.reps.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.noetzold.reps.dto.RequisicaoNovoObjapi;
import tech.noetzold.reps.model.Objapi;
import tech.noetzold.reps.model.User;
import tech.noetzold.reps.repository.ObjapiRepository;
import tech.noetzold.reps.repository.UserRepository;

@Controller
@RequestMapping("objapi")
public class ObjapiController {
	@Autowired
	private ObjapiRepository objapiRepository;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("formulario")
	public String formulario(RequisicaoNovoObjapi requisicao) {
		return "objapi/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoObjapi requisicao, BindingResult result) {
		if(result.hasErrors()) {
			return "objapi/formulario";
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		User usuario = userRepository.findByUsername(username);
		Objapi objapi = requisicao.toObjapi();
		objapi.setUser(usuario);
		objapiRepository.save(objapi);
		return "redirect:/home";
	}
}
