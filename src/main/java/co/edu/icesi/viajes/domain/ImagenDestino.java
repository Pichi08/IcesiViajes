package co.edu.icesi.viajes.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "imagen_destino")
public class ImagenDestino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imag")
    private Integer idImag;

    @Column(name = "url_img")
    @NotBlank(message = "URL de la imagen es obligatoria")
    private String urlImg;

    @Column(name = "id_plan")
    @NotNull(message = "ID del plan es obligatorio")
    private Integer idPlan;
}