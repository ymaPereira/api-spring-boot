package cv.developer.cricle.repositories;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import cv.developer.cricle.domain.Event;

public interface EventoReporisoty extends JpaRepository<Event, String>{

	List<Event> findByThemeIgnoreCase(String theme);
	
	List<Event> findByEventDate(LocalDate eventDate);
}
