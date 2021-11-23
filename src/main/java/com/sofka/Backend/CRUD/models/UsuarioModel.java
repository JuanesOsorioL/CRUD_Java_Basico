package com.sofka.Backend.CRUD.models;

import javax.persistence.*;

@Entity//modelo real
@Table(name="usuario")//nombre de la tabla
public class UsuarioModel {

    @Id//clave primaria
    @GeneratedValue(strategy =GenerationType.IDENTITY)//se genera automaticamente y es autoincrementrable
    @Column(unique = true,nullable = false)//unico y que no puede ser nulo
    private Long id;

    
    private String nombre;
    private String email;
    private Integer prioridad;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }
}
