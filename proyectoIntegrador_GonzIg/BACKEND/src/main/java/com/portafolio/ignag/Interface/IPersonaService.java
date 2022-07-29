package com.portafolio.ignag.Interface;

import java.util.List;
import com.portafolio.ignag.Entity.Persona;

public interface IPersonaService {
    /*traer una lista de personas*/
    public List<Persona> getPersona();

    /*Guardar un objeto de tipo personas */

    public void savePersona(Persona persona);

    /*Eliminar un usuario*/

    public void deletePersona(Long id);

    /*Buscar una persona por id */

    public Persona findPersona(Long id);
}
