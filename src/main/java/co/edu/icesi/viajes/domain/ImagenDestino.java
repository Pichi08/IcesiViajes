package co.edu.icesi.viajes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "imagen_destino")
public class ImagenDestino {

    @Id
    @Column(name = "id_imag")
    private Integer idImag;

    @Column(name = "url_img")
    private String urlImg;

    @Column(name = "id_plan")
    private Integer idPlan;
}