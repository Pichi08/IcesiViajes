package co.edu.icesi.viajes.service;


import co.edu.icesi.viajes.dto.PermisoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest

public class PermisoTest {

    @Autowired
    private PermisoService permisoService;



    @Test
    void debeConsultarPermisoPorRol() {
        List<PermisoDTO> lstPermiso = permisoService.consultaPermisoPorRol("ADMIN");

        for (PermisoDTO permiso : lstPermiso) {
            System.out.println(permiso.getNombre());
        }
    }



}
