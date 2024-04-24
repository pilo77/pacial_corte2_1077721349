package com.corhuila.tareasdomestica.Controller;

import com.corhuila.tareasdomestica.Entity.Evento;
import com.corhuila.tareasdomestica.Entity.Miembro;
import com.corhuila.tareasdomestica.IService.IMiembroService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("api/miembro")
public class MiembroController {
    @Autowired
    private IMiembroService service;

    @Operation(summary = "Mostrar todos los miembros de la familia")
    @GetMapping("/miembros")
    public List<Miembro> findAll() {

        return service.findAll();
    }
    //---------------------------------------------------------------------------

    @Operation(summary = "Mostrar por Id al miembro de la familia especifo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Miembro encontrado con exito",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Evento.class))
                    }),
            @ApiResponse(responseCode = "500", description = "id invalid", content = @Content)
    })
    @GetMapping("/{id}")
    public Optional<Miembro> findById(@PathVariable Long id) {

        return service.findById(id);
    }
    //---------------------------------------------------------------------------


    @Operation(summary = "Crear miembros de la familia en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Miembro creado con exito",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Evento.class))
                    }),
            @ApiResponse(responseCode = "500", description = "Error de parametros", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error de response", content = @Content)


    })

    @PostMapping("/guardar")
    public Miembro save(@RequestBody Miembro miembro) {
        return service.save(miembro);
    }
    //---------------------------------------------------------------------------


    @Operation(summary = "Actualizar miembros de la familia agregados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Miembro actualizado con exito",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Evento.class))
                    }),
            @ApiResponse(responseCode = "500", description = "Error de parametros", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error de response", content = @Content)


    })


    @PutMapping("editar/{id}")
    public void update(@RequestBody Miembro miembro, @PathVariable Long id) {

        service.update(miembro, id);
    }


    //---------------------------------------------------------------------------


    @Operation(summary = "eliminar miembro de la familia de la base de datos por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Miembro eliminado con exito",
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
