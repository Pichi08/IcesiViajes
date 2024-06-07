package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Plan;
import co.edu.icesi.viajes.domain.Usuario;
import co.edu.icesi.viajes.dto.PlanDTO;
import co.edu.icesi.viajes.repository.PlanRepository;
import co.edu.icesi.viajes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class PlanServiceImpl implements PlanService{

    @Autowired
    PlanRepository planRepository;
    @Autowired
    UsuarioService usuarioService;

    @Override
    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    @Override
    public Optional<Plan> findById(Integer id) {
        return planRepository.findById(id);
    }

    @Override
    public Plan save(Plan entity) throws Exception {
        Usuario usuario = usuarioService.findUsuarioByLogin(entity.getUsuario().getLogin());
        entity.setUsuario(usuario);
        return planRepository.save(entity);
    }

    @Override
    public Plan update(Plan entity) throws Exception {
        Optional<Plan> plan = planRepository.findById(entity.getIdPlan());
        if (plan.isPresent()){
            Plan plan1 = plan.get();
            plan1.setCodigo(entity.getCodigo());
            plan1.setDescripcionSolicitud(entity.getDescripcionSolicitud());
            plan1.setNombre(entity.getNombre());
            plan1.setCantidadPersonas(entity.getCantidadPersonas());
            plan1.setFechaInicioViaje(entity.getFechaInicioViaje());
            plan1.setFechaFinViaje(entity.getFechaFinViaje());
            plan1.setValorTotal(entity.getValorTotal());
            plan1.setFechaModificacion(entity.getFechaModificacion());
            plan1.setUsuModificador(entity.getUsuModificador());
            return planRepository.save(plan1);
        }
        return null;
    }

    @Override
    public void delete(Plan entity) throws Exception {
        planRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer integer) throws Exception {
        planRepository.deleteById(integer);
    }

    @Override
    public void validate(Plan entity) throws Exception {

    }

    @Override
    public Long count() {
        return planRepository.count();
    }

    @Override
    public List<PlanDTO> consultarTodosPlanesImagenes() {
        return planRepository.consultarTodosPlanesImagenes();
    }

    @Override
    public List<String> findAllPlanNamesAndDescription() {
        return planRepository.findAllPlanNamesAndDescription();
    }

    @Override
    public List<Plan> findByFechaInicioViajeOrFechaFinViaje(Date fechaInicio, Date fechaFin) {
        return planRepository.findByFechaInicioViajeOrFechaFinViaje(fechaInicio, fechaFin);
    }

    @Override
    public List<PlanDTO> findByCriterios(String nombreDest, Date fechaInicio, Date fechaFin, Integer cantidadPer) {
        return null;
    }

    @Override
    public List<PlanDTO> consultarPlanesBusqueda(String nombre) {
        return planRepository.consultarPlanesBusqueda(nombre);
    }

    @Override
    public List<PlanDTO> consultarPlanesFechasBusqueda(String nombre, Date fechaInicio, Date fechaFin) {
        return planRepository.consultarPlanesFechasBusqueda(nombre, fechaInicio, fechaFin);
    }

    @Override
    public List<PlanDTO> consultarPlanesYPersonasBusqueda(String nombre, Integer personas) {
        return planRepository.consultarPlanesYPersonasBusqueda(nombre, personas);
    }

    @Override
    public List<PlanDTO> consultarPlanesYFechasYPersonasBusqueda(String nombre, Date fechaInicio, Date fechaFin, Integer personas) {
        return planRepository.consultarPlanesYFechasYPersonasBusqueda(nombre, fechaInicio, fechaFin, personas);
    }

    @Override
    public List<PlanDTO> consultarPotencialAsesores() {
        return planRepository.consultarPotencialAsesores();
    }

    @Override
    public PlanDTO consultarTotalVentas() {
        return planRepository.consultarTotalVentas();
    }

    @Override
    public PlanDTO consultarVentasReales() {
        return planRepository.consultarVentasReales();
    }
}
