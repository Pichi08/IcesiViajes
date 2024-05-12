package co.edu.icesi.viajes.service;


import co.edu.icesi.viajes.domain.Cliente;
import co.edu.icesi.viajes.domain.Plan;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PlanTest {

    @Autowired
    private PlanService planService;

    @Test
    void debeConsultarClientePorEstado() throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Plan> lstCliente = planService.findByFechaInicioViajeOrFechaFinViaje(dateFormat.parse("2021-05-02"),dateFormat.parse("2021-05-07"));

        System.out.println(lstCliente);


    }

}
