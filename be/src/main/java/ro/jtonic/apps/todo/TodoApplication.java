package ro.jtonic.apps.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.jtonic.apps.todo.model.domain.Person;
import ro.jtonic.apps.todo.model.domain.PersonDTO;
import ro.jtonic.apps.todo.model.mapping.PersonMapper;

@SpringBootApplication
@RestController
public class TodoApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TodoApplication.class);
	
	private PersonMapper personMapper;
	
	public TodoApplication(PersonMapper personMapper) {
		
		this.personMapper = personMapper;
	}

	@GetMapping
	public PersonDTO greeting() {
		
		final Person person = Person.builder().firstName("Antonel-Ernest").lastName("Pazargic").age((byte) 49).build();
		final PersonDTO personDTO = personMapper.mapToPersonDTO(person);
		LOGGER.debug(String.format("Hi %s", personDTO));
		return personDTO;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}
}
