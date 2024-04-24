package com.corhuila.tareasdomestica.Controller;

import com.corhuila.tareasdomestica.Entity.Evento;
import com.corhuila.tareasdomestica.IService.IEventoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/evento")
public class EventoController {
    //Inyectar DEPENDECIAS el servicio
    @Autowired
    private IEventoService service;

    @Operation(summary = "Mostrar todos los eventos")
    @GetMapping("/eventos")
    public List<Evento> findAll() {
        return service.findAll();
    }

    //-------------------------------------------------------------------------------------------------------------
    @Operation(summary = "Mostrar por Id evento especificado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Evento encontrado con exito",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Evento.class))
                    }),
            @ApiResponse(responseCode = "500", description = "id invalid", content = @Content)
    })
    @GetMapping("/{id}")
    public Optional<Evento> findById(@Parameter(description = "id de evento ", example = "1") @PathVariable Long id) {
        return service.findById(id);
    }
    //----------------------------------------------------------------------------------------------------------------

    @Operation(summary = "Crear eventos en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Evento creado con exito",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Evento.class))
                    }),
            @ApiResponse(responseCode = "500", description = "Error de parametros", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error de response", content = @Content)


    })
    @PostMapping("/guardar")
    public Evento save(@RequestBody Evento evento) {
        return service.save(evento);
    }
    //------------------------------------------------------------------------------------------

    @Operation(summary = "Actualizar eventos prolongados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Evento actualizado con exito",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Evento.class))
                    }),
            @ApiResponse(responseCode = "500", description = "Error de parametros", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error de response", content = @Content)


    })
    @PutMapping("editar/{id}")
    public void update(@RequestBody Evento evento, @PathVariable Long id) {
        service.update(evento, id);

    }

    //---------------------------------------------------------------------------
    @Operation(summary = "eliminar evento de la base de datos por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Evento eliminado con exito",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Evento.class))
                    }),
            @ApiResponse(responseCode = "500", description = "Error de parametros", content = @Content),


    })
    @DeleteMapping("eliminar/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


}
