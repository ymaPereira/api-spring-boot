package cv.developer.cricle.apis;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import cv.developer.cricle.domain.Evento;
import cv.developer.cricle.services.EventoService;

@RestController
@RequestMapping("/evento")
public class EventoApi {

	private final EventoService eventoService;

	public EventoApi(EventoService eventoService) {
		super();
		this.eventoService = eventoService;
	}
	
	@PostMapping
	@ResponseStatus(value =  HttpStatus.CREATED)
	public Evento createEvento(@RequestBody(required = true) Evento evento) {
		return eventoService.create(evento);
	}
	

	@PutMapping("/{id}")
	@ResponseStatus(value =  HttpStatus.OK)
	public Evento updateEvento(@PathVariable Long id,@RequestBody(required = true) Evento evento) {
		return eventoService.update(id,evento);
	}
	
	@GetMapping
	@ResponseStatus(value =  HttpStatus.OK)
	public List<Evento> getEventos() {
		return eventoService.findAll();
	} 
}
