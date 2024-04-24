package com.corhuila.tareasdomestica.IService;

import java.util.List;
import java.util.Optional;

import com.corhuila.tareasdomestica.Entity.Evento;

public interface IEventoService {
    List<Evento> findAll(); // Devuelve una lista de Eventos
    Optional<Evento> findById(Long id); // Devuelve un Evento por su id
    Evento save(Evento Evento); // Guarda un Evento
    void update(Evento Evento, Long id); // Actualiza un Evento
    void delete(Long id); // Elimina un Evento
}
