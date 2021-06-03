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

import tech.noetzold.reps.model.Objrep;
import tech.noetzold.reps.model.StatusRep;
import tech.noetzold.reps.repository.ObjrepRepository;


@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private ObjrepRepository objRepRepository;
	
	@GetMapping
	public String home(Model model, Principal principal) {
		Sort sort = Sort.by("nomeRep").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		
		List<Objrep> objreps = objRepRepository.findByStatus(StatusRep.DESENVOLVIMENTO, paginacao);
		model.addAttribute("objreps", objreps);
		
		return "home";
	}
	
}