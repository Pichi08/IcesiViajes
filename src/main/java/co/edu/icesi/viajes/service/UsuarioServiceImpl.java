package co.edu.icesi.viajes.service;


import co.edu.icesi.viajes.domain.Usuario;
import co.edu.icesi.viajes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Scope("singleton")
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario save(Usuario entity) throws Exception {
        return usuarioRepository.save(entity);
    }

    @Override
    public Usuario update(Usuario entity) throws Exception {
        Optional<Usuario> usuario = usuarioRepository.findById(entity.getIdUsua());
        if (usuario.isPresent()){
            Usuario usuario1 = usuario.get();
            usuario1.setLogin(entity.getLogin());
            usuario1.setPassword(entity.getPassword());
            usuario1.setNombre(entity.getNombre());
            usuario1.setIdentificacion(entity.getIdentificacion());
            usuario1.setId_rol(entity.getId_rol());
            usuario1.setFechaModificacion(entity.getFechaModificacion());
            usuario1.setUsuModificador(entity.getUsuModificador());
            return usuarioRepository.save(usuario1);

        }
        return null;
    }

    @Override
    public void delete(Usuario entity) throws Exception {
        usuarioRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void validate(Usuario entity) throws Exception {

    }

    @Override
    public Long count() {
        return usuarioRepository.count();
    }

    @Override
    public Usuario findUsuarioByLogin(String login) {
        return usuarioRepository.findUsuarioByLogin(login);
    }

}
