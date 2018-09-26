package com.loja.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.handler.EventoDataInicioMaiorQueFinal;
import com.loja.handler.EventoNaoExiste;
import com.loja.models.Evento;
import com.loja.repository.EventosRepository;

@Service
public class EventosService {

	@Autowired
	private EventosRepository eventos;

	public List<Evento> listarTodos() {
		return eventos.findAll();
	}

	public Evento buscarId(Long id) {
		Optional<Evento> eventoId = eventos.findById(id);

		if (!eventoId.isPresent()) {
			throw new EventoNaoExiste("Evento não pode ser encontrado");
		}

		return eventoId.get();
	}

	public Evento salvar(Evento evento) {
		 		
		try {
			SimpleDateFormat dateFormatInicio = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat dateFormatFim = new SimpleDateFormat("dd/MM/yyyy");
			
			Date dataIncial = dateFormatInicio.parse(evento.getInicio());
			Date dataFinal = dateFormatFim.parse(evento.getFim());
			
			if (dataIncial.compareTo(dataFinal) < 0 || dataIncial.compareTo(dataFinal) == 0) {
				return eventos.save(evento);
			} else {
				throw new EventoDataInicioMaiorQueFinal("A data de inicio não pode ser maior que a data final");
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void atualizar(Evento evento) {
		verificaExistencia(evento);

		eventos.save(evento);
	}

	public void deletar(Long id) {
		try {
			eventos.deleteById(id);
		} catch (Exception e) {
			throw new EventoNaoExiste("Evento não pode ser encontrado");
		}
	}

	private void verificaExistencia(Evento evento) {
		buscarId(evento.getId());
	}

}
