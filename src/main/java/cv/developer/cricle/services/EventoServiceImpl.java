package cv.developer.cricle.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cv.developer.cricle.domain.Evento;
import cv.developer.cricle.repositories.EventoReporisoty;

@Service
public class EventoServiceImpl implements EventoService{

	
	private final EventoReporisoty eventoRepository;
	
	
	public EventoServiceImpl(EventoReporisoty eventoRepository) {
		super();
		this.eventoRepository = eventoRepository;
	}

	@Override
	public Evento create(Evento evento) {
		// TODO Auto-generated method stub
		return eventoRepository.save(evento);
	}

	@Override
	public Evento update(Long id, Evento evento) {
		return eventoRepository.findById(id).map(e->{
			e.setAutor(evento.getAutor());
			e.setDataEvento(evento.getDataEvento());
			e.setOrganizador(evento.getOrganizador());
			e.setTema(evento.getTema());
			return eventoRepository.save(e);
		}).orElseGet(()->{
			evento.setId(id);
			return eventoRepository.save(evento);
		});
	}

	@Override
	public List<Evento> findAll() {
		// TODO Auto-generated method stub
		return eventoRepository.findAll();
	}

	@Override
	public List<Evento> findByTema(String tema) {
		// TODO Auto-generated method stub
		return eventoRepository.findByTemaIgnoreCase(tema);
	}

}
