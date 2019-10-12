package ro.jtonic.apps.todo.model.mapping;

import org.mapstruct.Mapper;
import ro.jtonic.apps.todo.model.domain.Person;
import ro.jtonic.apps.todo.model.domain.PersonDTO;

/**
 * Created by Antonel Ernest Pazargic on 06/10/2019.
 *
 * @author Antonel Ernest Pazargic
 */
@Mapper
public interface PersonMapper {
  
  PersonDTO mapToPersonDTO(Person person);
  
  Person mapToPerson(PersonDTO personDTO);
}
