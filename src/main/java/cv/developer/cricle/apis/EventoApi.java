package cv.developer.cricle.apis;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import cv.developer.cricle.domain.Event;
import cv.developer.cricle.services.EventoService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/event")
@Slf4j
public class EventoApi {

	private final EventoService eventoService;

	public EventoApi(EventoService eventoService) {
		super();
		this.eventoService = eventoService;
	}
	
	@PostMapping
	@ResponseStatus(value =  HttpStatus.CREATED)
	public Event createEvento(@Validated @RequestBody(required = true) Event evento) {
		log.info("Creating event...");
		return eventoService.create(evento);
	}
	

	@PutMapping("/{id}")
	@ResponseStatus(value =  HttpStatus.OK)
	public Event updateEvento(@PathVariable UUID id,@Validated @RequestBody(required = true) Event evento) {
		log.info("Updating event...");
		return eventoService.update(id.toString(),evento);
	}
	
	@GetMapping
	public ResponseEntity<List<Event>> getEventos() {
		return new ResponseEntity<List<Event>>(eventoService.findAll(),HttpStatus.OK);
	} 
	

	@GetMapping("/search")
	@ResponseStatus(value =  HttpStatus.OK)
	public List<Event> getSearchEventos(@RequestParam("eventDate") LocalDate eventDate,@RequestParam("theme") String theme) {
		List<Event> eventos = new ArrayList<>();
		if(eventDate != null) {
			eventos.addAll(eventoService.findByEventDate(eventDate));
		}
		if(theme != null) {
			eventos.addAll(eventoService.findByTheme(theme));
		}
		return eventos;
	} 
	
	@DeleteMapping("/{id}")
	public void deleteEvento(@PathVariable UUID id) {
		log.info("Deleting event...");
		eventoService.delete(id.toString());
	}
}
