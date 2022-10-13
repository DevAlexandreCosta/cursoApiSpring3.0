package com.devalexandrecosta.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devalexandrecosta.data.vo.v1.PersonVO;
import com.devalexandrecosta.exceptions.ResourceNotFoundException;
import com.devalexandrecosta.mapper.DozeMapper;
import com.devalexandrecosta.model.Person;
import com.devalexandrecosta.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	// adicionando a injeção de dependências no serviço

	@Autowired
	PersonRepository repository;

	public List<PersonVO> findAll() {
		logger.info("Finding all people !");

		return DozeMapper.parseListObject(repository.findAll(),PersonVO.class) ;

	}

	public PersonVO findById(Long id) {
		logger.info("Finding one person !");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" No Records found for this ID!"));
		return DozeMapper.parseObject(entity,PersonVO.class);
	}

	public PersonVO create(PersonVO person) {
		
		logger.info("Creating one person !");
		var entity = DozeMapper.parseObject(person,Person.class);
		var vo =  DozeMapper.parseObject(repository.save(entity),PersonVO.class);
		return vo; 
	}

	public PersonVO update(PersonVO person) {
		logger.info("updating one person !");
		
		var entity = repository.findById(person.getId())
			.orElseThrow(() -> new ResourceNotFoundException(" No Records found for this ID!"));
		entity.setFirstName(person.getFirstName());
		entity.setLirstName(person.getLirstName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		var vo = DozeMapper.parseObject(repository.save(entity),PersonVO.class); return person;
	
		
	}

	public void delete(Long id) {
		logger.info("Deleting one person !");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" No Records found for this ID!"));
		repository.delete(entity);
	}

}
