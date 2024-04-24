package com.corhuila.tareasdomestica.Entity;



import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="descripcion",nullable = false)
    private String descripcion;


    @Column(name = "fechaLimite", nullable = false)
    private LocalDateTime fechaLimite;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "miembro_id", nullable = false)
    //indica que esta entidad tiene una columna llamada
    // "miembro_id" que actúa como llave foránea
    private  Miembro miembro;

    public Evento() {
    }

    public Evento(long id, String descripcion, LocalDateTime fechaLimite, Miembro miembro) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.miembro = miembro;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDateTime fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }
}
