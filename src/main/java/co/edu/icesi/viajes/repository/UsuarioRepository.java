package co.edu.icesi.viajes.repository;
import co.edu.icesi.viajes.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    Optional<Usuario> findByLogin(String username);
    boolean existsUsuarioByLogin(String username);

    @Query(nativeQuery = true)
    String consultarNombreRolPorId(@Param("pIdRol") Integer id);


}
