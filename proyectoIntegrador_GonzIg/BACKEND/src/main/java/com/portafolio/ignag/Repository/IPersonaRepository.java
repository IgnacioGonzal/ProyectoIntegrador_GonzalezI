package com.portafolio.ignag.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portafolio.ignag.Entity.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long> {
    
}
