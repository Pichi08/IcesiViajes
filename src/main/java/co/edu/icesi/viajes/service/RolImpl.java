package co.edu.icesi.viajes.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class RolImpl implements RolService{
    @Override
    public List<RolService> findAll() {
        return null;
    }

    @Override
    public Optional<RolService> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public RolService save(RolService entity) throws Exception {
        return null;
    }

    @Override
    public RolService update(RolService entity) throws Exception {
        return null;
    }

    @Override
    public void delete(RolService entity) throws Exception {

    }

    @Override
    public void deleteById(Integer integer) throws Exception {

    }

    @Override
    public void validate(RolService entity) throws Exception {

    }

    @Override
    public Long count() {
        return null;
    }
}
