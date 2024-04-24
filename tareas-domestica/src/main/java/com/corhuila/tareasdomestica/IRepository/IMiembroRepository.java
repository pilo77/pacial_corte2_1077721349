package com.corhuila.tareasdomestica.IRepository;


import com.corhuila.tareasdomestica.Entity.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiembroRepository extends JpaRepository<Miembro,Long> {

}
