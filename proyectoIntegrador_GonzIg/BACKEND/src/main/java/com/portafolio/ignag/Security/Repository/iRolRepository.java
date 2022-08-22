package com.portafolio.ignag.Security.Repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portafolio.ignag.Security.Entity.Rol;
import com.portafolio.ignag.Security.Enums.RolNombre;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
