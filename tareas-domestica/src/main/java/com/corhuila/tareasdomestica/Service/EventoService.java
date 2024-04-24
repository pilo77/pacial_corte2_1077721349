package com.corhuila.tareasdomestica.Service;

import com.corhuila.tareasdomestica.Entity.Evento;
import com.corhuila.tareasdomestica.IRepository.IEventoRepository;
import com.corhuila.tareasdomestica.IService.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService implements IEventoService {

    @Autowired
    private IEventoRepository repository;

    @Override
    public List<Evento>findAll(){
        return repository.findAll();
    }

    @Override
    public Optional<Evento> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Evento save(Evento evento) {
      return  repository.save(evento);
    }

    @Override
    public void update(Evento evento, Long id) {
        //Verificar con el id, si exiten los datos
        Optional<Evento>ps= repository.findById(id);

        if(!ps.isEmpty()){
            Evento eventoUpdate= ps.get();
            eventoUpdate.setDescripcion(evento.getDescripcion());
            eventoUpdate.setFechaLimite(evento.getFechaLimite());
            eventoUpdate.setMiembro(evento.getMiembro());


        }else{
            System.out.println("No existe el evento");
        }


    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


}
