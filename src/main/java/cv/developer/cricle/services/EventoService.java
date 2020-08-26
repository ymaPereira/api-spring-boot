package cv.developer.cricle.services;

import java.time.LocalDate;
import java.util.List;
import cv.developer.cricle.domain.Event;

public interface EventoService {

	Event create(Event evento);
	
	Event update(String id,Event evento);
	
	List<Event> findAll();
	
	List<Event> findByTheme(String theme);
	
	List<Event> findByEventDate(LocalDate eventDate);
	
	void delete(String id);
}
