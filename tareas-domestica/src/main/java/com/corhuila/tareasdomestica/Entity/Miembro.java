package com.corhuila.tareasdomestica.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "miembro")
public class Miembro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "rol", length = 50, nullable = false)
    private String rol;

    public Miembro() {
    }

    public Miembro(Long id, String nombre, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

