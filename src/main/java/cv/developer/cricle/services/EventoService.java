package cv.developer.cricle.services;

import java.util.List;

import cv.developer.cricle.domain.Evento;

public interface EventoService {

	Evento create(Evento evento);
	
	Evento update(Long id,Evento evento);
	
	List<Evento> findAll();
	
	List<Evento> findByTema(String tema);
}
