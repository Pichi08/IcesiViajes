package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Usuario;

import java.util.Optional;

public interface UsuarioService extends GenericService<Usuario, Integer>{
    Usuario findUsuarioByLogin(String login);



}
