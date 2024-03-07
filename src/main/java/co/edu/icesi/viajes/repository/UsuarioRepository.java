package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    //public List<Usuario> findByCodigoOrderByCodigoAsc(String codigo);
}
