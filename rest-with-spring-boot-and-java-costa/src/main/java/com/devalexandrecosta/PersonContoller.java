package com.devalexandrecosta;

import java.util.List;

import javax.print.attribute.standard.MediaTray;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devalexandrecosta.model.Person;
import com.devalexandrecosta.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonContoller {

//	usando anotaçao @service com @autowired
	@Autowired
	private PersonServices service;
	// sem usar @service private PersonServices services = new PersonServices();

	@GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public  List<Person> findAll()  {
		return service.findAll();
	}
		
	@GetMapping(value= "/{id}",
				produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
		public Person findById(
				@PathVariable(value = "id") Long id)  {
			return service.findById(id);
//		
	}
		

		@DeleteMapping(value= "/{id}")
		public ResponseEntity<?>delete(	@PathVariable(value = "id") Long id)  {
			service.delete(id);

			return ResponseEntity.noContent().build();
	}	
		
		@PostMapping( consumes  = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
				produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
		public Person create(@RequestBody Person person)  {
			return service.create(person);
//		
	}
		
		@PutMapping(consumes  = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
				produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
		public Person update(@RequestBody Person person)  {
			return service.update(person);
//		
	}
}
