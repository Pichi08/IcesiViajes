package co.edu.icesi.viajes.domain;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Data
@Entity
@Table(name="rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;

    @Column(name = "nombre")
    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;

    @Column(name = "estado")
    @NotNull(message = "Estado es obligatorio")
    private String estado;
}