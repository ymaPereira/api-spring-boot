package cv.developer.cricle.services;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import cv.developer.cricle.domain.Event;
import cv.developer.cricle.repositories.EventoReporisoty;

@Service
public class EventoServiceImpl implements EventoService{

	
	private final EventoReporisoty eventoRepository;
	
	
	public EventoServiceImpl(EventoReporisoty eventoRepository) {
		super();
		this.eventoRepository = eventoRepository;
	}

	@Override
	public Event create(Event evento) {
		evento.setId(UUID.randomUUID().toString());
		return eventoRepository.save(evento);
	}

	@Override
	public Event update(String id, Event evento) {
		return eventoRepository.findById(id).map(e->{
			e.setAutor(evento.getAutor());
			e.setEventDate(evento.getEventDate());
			e.setOrganizers(e.getOrganizers());
			e.setTheme(e.getTheme());
			e.setDescription(evento.getDescription());
			e.setGuests(evento.getGuests());
			return eventoRepository.save(e);
		}).orElseGet(()->{
			evento.setId(id);
			return eventoRepository.save(evento);
		});
	}

	@Override
	public List<Event> findAll() {
		return eventoRepository.findAll();
	}

	@Override
	public List<Event> findByTheme(String theme) {
		return eventoRepository.findByThemeIgnoreCase(theme);
	}

	@Override
	public List<Event> findByEventDate(LocalDate eventDate) {
		return eventoRepository.findByEventDate(eventDate);
	}

	@Override
	public void delete(String id) {
		eventoRepository.deleteById(id);
	}

}
