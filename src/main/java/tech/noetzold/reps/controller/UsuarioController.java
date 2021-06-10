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

import tech.noetzold.reps.model.Objapi;
import tech.noetzold.reps.model.Objrep;
import tech.noetzold.reps.model.StatusApi;
import tech.noetzold.reps.model.StatusRep;
import tech.noetzold.reps.repository.ObjapiRepository;
import tech.noetzold.reps.repository.ObjrepRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private ObjrepRepository objrepRepository;
	
	@Autowired
	private ObjapiRepository objApiRepository;
	
	@GetMapping("obj")
	public String home(Model model, Principal principal) {
		List<Objrep> objrep = objrepRepository.findAllByUsuario(principal.getName());
		model.addAttribute("objreps", objrep);
		List<Objapi> objapi = objApiRepository.findAllByUsuario(principal.getName());
		model.addAttribute("objapis", objapi);
		
		return "usuario/home";
	}
	
	@GetMapping("objrep/{status}")
	public String porStatusRep(@PathVariable("status") String status, Model model, Principal principal) {
		List<Objrep> objrep = objrepRepository.findByStatusEUsuario(StatusRep.valueOf(status.toUpperCase()), principal.getName());
		model.addAttribute("objreps", objrep);
		
		model.addAttribute("status", status);
		return "usuario/home";
	}
	
	@GetMapping("objapi/{status}")
	public String porStatusApi(@PathVariable("status") String status, Model model, Principal principal) {
		List<Objapi> objapi = objApiRepository.findByStatusEUsuario(StatusApi.valueOf(status.toUpperCase()), principal.getName());
		model.addAttribute("objapis", objapi);
		
		model.addAttribute("status", status);
		return "usuario/home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/usuario/home";
	}
}