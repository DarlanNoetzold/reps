package tech.noetzold.reps.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.noetzold.reps.model.Objapi;
import tech.noetzold.reps.model.Objrep;
import tech.noetzold.reps.model.StatusApi;
import tech.noetzold.reps.model.StatusRep;
import tech.noetzold.reps.repository.ObjapiRepository;
import tech.noetzold.reps.repository.ObjrepRepository;


@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private ObjrepRepository objRepRepository;
	
	@Autowired
	private ObjapiRepository objApiRepository;
	
	@GetMapping
	public String home(Model model, Principal principal) {
		Sort sortreps = Sort.by("nomeRep").descending();
		PageRequest paginacaoreps = PageRequest.of(0, 10, sortreps);
		
		Sort sortapis = Sort.by("nomeApi").descending();
		PageRequest paginacaoapis = PageRequest.of(0, 10, sortapis);
		
		List<Objapi> objapis = objApiRepository.findByStatus(StatusApi.ATIVADO, paginacaoapis);
		List<Objrep> objreps = objRepRepository.findByStatus(StatusRep.DESENVOLVIMENTO, paginacaoreps);
		model.addAttribute("objapis", objapis);
		model.addAttribute("objreps", objreps);
		
		
		return "home";
	}
	
}