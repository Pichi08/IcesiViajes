package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Usuario;
import co.edu.icesi.viajes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    /*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(username).orElseThrow();
    }

     */


    /*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(username).orElseThrow();
        return new User(usuario.getLogin(), usuario.getPassword(), mapRolesToAuthorities(usuario.getId_rol()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Integer idRol) {
        // Lógica para mapear el ID del rol a las autoridades/granted authorities adecuadas
        String rolAuthority = getAuthorityFromId(idRol);
        return Collections.singleton(new SimpleGrantedAuthority(rolAuthority));
    }

     */

    public String getAuthorityFromId(Integer idRol) {
        return usuarioRepository.consultarNombreRolPorId(idRol);

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(username).orElseThrow();
        GrantedAuthority authority = new SimpleGrantedAuthority(getAuthorityFromId(usuario.getId_rol()));
        //System.out.println("TIPO DE ROL EN JwtUserDetailsService "+ authority);

        return new User(usuario.getUsername(),
                usuario.getPassword(),
                true,
                true,
                true,
                true,
                Collections.singleton(authority)
                );
    }



}
