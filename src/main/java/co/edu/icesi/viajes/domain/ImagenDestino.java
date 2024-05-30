package co.edu.icesi.viajes.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

//@Data
@Getter
@Setter
@Entity
@Table(name = "imagen_destino")
@AllArgsConstructor
@NoArgsConstructor
public class ImagenDestino {
    public ImagenDestino(String nombre, String urlImg, String imageId) {
        this.nombre = nombre;
        this.urlImg = urlImg;
        this.imageId = imageId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imag")
    private Integer idImag;

    @Column(name = "nombre")
    @NotBlank(message = "URL de la imagen es obligatoria")
    private String nombre;

    @Column(name = "url_img")
    @NotBlank(message = "URL de la imagen es obligatoria")
    private String urlImg;

    @Column(name = "imageid")
    @NotBlank(message = "URL de la imagen es obligatoria")
    private String imageId;

    @Column(name = "id_plan")
    @NotNull(message = "El id del plan es obligatorio")
    private Integer idPlan;







}