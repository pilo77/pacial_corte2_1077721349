package com.corhuila.tareasdomestica.Service;


import com.corhuila.tareasdomestica.Entity.Miembro;
import com.corhuila.tareasdomestica.IRepository.IMiembroRepository;
import com.corhuila.tareasdomestica.IService.IMiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MiembroService implements IMiembroService {

    @Autowired
    private IMiembroRepository repository;

    @Override
    public List<Miembro> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Miembro> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Miembro save(Miembro miembro) {
        return repository.save(miembro);
    }

    @Override
    public void update(Miembro miembro, Long id) {
        //Obtener el objeto miembro y el id
        //Verificar con el id, si exiten los datos
        Optional<Miembro> ps = repository.findById(id);

        //Cargar nuevo objeto
        if (!ps.isEmpty()){
            Miembro miembroUpdate = ps.get();
            miembroUpdate.setNombre(miembro.getNombre());
            miembroUpdate.setRol(miembro.getRol());


            //Actualizar el objeto miembro
            repository.save(miembroUpdate);
        }else{
            System.out.println("No existe el miembro");
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


}
