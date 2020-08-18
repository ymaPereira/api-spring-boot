package cv.developer.cricle.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cv.developer.cricle.domain.Evento;

public interface EventoReporisoty extends JpaRepository<Evento, Long>{

	List<Evento> findByTemaIgnoreCase(String tema);
}
