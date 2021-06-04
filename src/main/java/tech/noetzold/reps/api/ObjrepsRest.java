package tech.noetzold.reps.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.noetzold.reps.model.Objrep;
import tech.noetzold.reps.model.StatusRep;
import tech.noetzold.reps.repository.ObjrepRepository;

@RestController
@RequestMapping("/api/pedidos")
public class ObjrepsRest {
	@Autowired
	private ObjrepRepository pedidoRepository;
	
	@GetMapping("aguardando")
	public List<Objrep> getPedidosAguardandoOfertas() {
		Sort sort = Sort.by("id").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		
		return pedidoRepository.findByStatus(StatusRep.DESENVOLVIMENTO, paginacao);
	}
}
