package com.corhuila.tareasdomestica.IService;


import com.corhuila.tareasdomestica.Entity.Miembro;

import java.util.List;
import java.util.Optional;

public interface IMiembroService {
    List<Miembro> findAll(); // Devuelve una lista de miembros
    Optional<Miembro> findById(Long id); // Devuelve un miembro por su id
    Miembro save(Miembro miembro); // Guarda un miembro
    void update(Miembro miembro, Long id); // Actualiza un miembro
    void delete(Long id); // Elimina un miembro


}
