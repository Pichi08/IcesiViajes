package co.edu.icesi.viajes.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


@Data
public class PermisoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 5390344198279819979L;

    public PermisoDTO(String nombre) {
        this.nombre = nombre;
    }

    private Integer id_per;
    private String nombre;
    private String estado;
    private Integer id_rol;
}
