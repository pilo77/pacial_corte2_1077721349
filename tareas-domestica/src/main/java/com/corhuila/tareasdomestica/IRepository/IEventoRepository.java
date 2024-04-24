package com.corhuila.tareasdomestica.IRepository;

import com.corhuila.tareasdomestica.Entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEventoRepository extends JpaRepository<Evento,Long>{
}
