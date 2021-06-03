package tech.noetzold.reps.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.noetzold.reps.dto.RequisicaoNovoObjrep;
import tech.noetzold.reps.model.Objrep;
import tech.noetzold.reps.model.User;
import tech.noetzold.reps.repository.ObjrepRepository;
import tech.noetzold.reps.repository.UserRepository;

@Controller
@RequestMapping("objrep")
public class ObjrepController {
	
	@Autowired
	private ObjrepRepository pedidoRepository;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("formulario")
	public String formulario(RequisicaoNovoObjrep requisicao) {
		return "objrep/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoObjrep requisicao, BindingResult result) {
		if(result.hasErrors()) {
			return "objrep/formulario";
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		User usuario = userRepository.findByUsername(username);
		Objrep pedido = requisicao.toObjrep();
		pedido.setUser(usuario);
		pedidoRepository.save(pedido);
		return "redirect:/home";
	}
}