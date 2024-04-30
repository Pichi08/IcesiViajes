package co.edu.icesi.viajes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="rol")
public class Rol {

    @Id
    @Column(name = "id_rol")
    private Integer id_rol;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estado")
    private String estado;
}