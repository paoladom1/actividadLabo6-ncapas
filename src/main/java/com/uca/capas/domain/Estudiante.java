package com.uca.capas.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(schema = "public", name="estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_estudiante")
    private Integer codigoEstudiante;

    @Size(message = "El campo no debe tener mas de 30 caracteres", max = 30)
    @NotEmpty(message = "El campo no debe estar vacio")
    @Column(name="nombre")
    private String nombre;

    @Size(message = "El campo no debe tener mas de 30 caracteres", max = 30)
    @NotEmpty(message = "El campo no debe estar vacio")
    @Column(name="apellido")
    private String apellido;

    @Min(value = 18, message = "No puede ser menor a 18 años")
    @NotNull(message = "El campo no debe estar vacio")
    @Column(name="edad")
    private Integer edad;

    @Column(name="estado")
    private Boolean estado;

    @OneToMany(mappedBy = "estudiante", fetch = FetchType.EAGER)
    private List<Computadora> computadoras;

    public Estudiante() {
    }

    public Integer getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(Integer codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Computadora> getComputadoras() {
        return computadoras;
    }

    public void setComputadoras(List<Computadora> computadoras) {
        this.computadoras = computadoras;
    }

    public String getEstadoDelegate() {
        if(this.estado ==  null) return "";
        else {
            return estado == true ? "Activo" : "Inactivo";
        }
    }
}
