package co.edu.icesi.viajes.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
@Data
public class RolUsuarioDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 6513613142107526830L;

    public RolUsuarioDTO(String nombre ){
        this.nombre = nombre;
    }

    private String nombre;
}
