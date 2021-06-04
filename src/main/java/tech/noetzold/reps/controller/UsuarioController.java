package tech.noetzold.reps.controller;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.noetzold.reps.model.Objrep;
import tech.noetzold.reps.model.StatusRep;
import tech.noetzold.reps.repository.ObjrepRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private ObjrepRepository objrepRepository;
	
	@GetMapping("objrep")
	public String home(Model model, Principal principal) {
		List<Objrep> objrep = objrepRepository.findAllByUsuario(principal.getName());
		model.addAttribute("objreps", objrep);
		return "usuario/home";
	}
	
	@GetMapping("objrep/{status}")
	public String porStatus(@PathVariable("status") String status, Model model, Principal principal) {
		List<Objrep> objrep = objrepRepository.findByStatusEUsuario(StatusRep.valueOf(status.toUpperCase()), principal.getName());
		model.addAttribute("objreps", objrep);
		model.addAttribute("status", status);
		return "usuario/home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/usuario/home";
	}
}