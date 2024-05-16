package co.edu.icesi.viajes.domain;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@Entity
@Table(name="usuario")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usua")
    private Integer idUsua;

    @Column(name = "login")
    @NotBlank(message = "El login es obligatorio")
    private String login;

    @Column(name = "password")
    @NotBlank(message = "La contraseña es obligatoria")
    private String password;

    @Column(name = "nombre")
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Column(name = "identificacion")
    private String identificacion;

    @Column(name = "fecha_creacion")
    @NotNull(message = "La fecha de creación es obligatoria")
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @Column(name = "usu_creador")
    @NotBlank(message = "El usuario creador es obligatorio")
    private String usuCreador;

    @Column(name = "usu_modificador")
    private String usuModificador;

    @Column(name = "estado")
    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    @Column(name = "id_rol")
    @NotNull(message = "El ID del rol es obligatorio")
    private Integer id_rol;


    /*
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_rol")
    private Rol rol;
     */


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (id_rol == 1){
            GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
            return Collections.singleton(authority);
        } else if (id_rol == 2){
            GrantedAuthority authority = new SimpleGrantedAuthority("ASESOR");
            return Collections.singleton(authority);
        } else if (id_rol == 3) {
            GrantedAuthority authority = new SimpleGrantedAuthority("ASESOR");
            return Collections.singleton(authority);
        }else
            return null;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}