package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.DetallePlan;
import co.edu.icesi.viajes.repository.DetallePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class DetallePlanServiceImpl implements DetallePlanService{

    @Autowired
    private DetallePlanRepository detallePlanRepository;

    @Override
    public List<DetallePlan> findAll() {
        return detallePlanRepository.findAll();
    }

    @Override
    public Optional<DetallePlan> findById(Integer id) {
        return detallePlanRepository.findById(id);
    }

    @Override
    public DetallePlan save(DetallePlan entity) throws Exception {
        return detallePlanRepository.save(entity);
    }

    @Override
    public DetallePlan update(DetallePlan entity) throws Exception {
        Optional<DetallePlan> detallePlan = detallePlanRepository.findById(entity.getIdDepl());
        if (detallePlan.isPresent()){
            DetallePlan detallePlan1 = detallePlan.get();
            detallePlan1.setAlimentacion(entity.getAlimentacion());
            detallePlan1.setHospedaje(entity.getHospedaje());
            detallePlan1.setTraslados(entity.getTraslados());
            detallePlan1.setCantidadNoches(entity.getCantidadNoches());
            detallePlan1.setCantidadDias(entity.getCantidadDias());
            detallePlan1.setFechaModificacion(entity.getFechaModificacion());
            detallePlan1.setUsuModificador(entity.getUsuModificador());
            detallePlan1.setIdDest(entity.getIdDest());

            return detallePlanRepository.save(detallePlan1);


        }
        return null;
    }

    @Override
    public void delete(DetallePlan entity) throws Exception {
        detallePlanRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        detallePlanRepository.deleteById(id);
    }

    @Override
    public void validate(DetallePlan entity) throws Exception {

    }

    @Override
    public Long count() {
        return detallePlanRepository.count();
    }

    @Override
    public DetallePlan findByPlanId(Integer idPlan) {
        return detallePlanRepository.findByPlanId(idPlan);
    }
}
