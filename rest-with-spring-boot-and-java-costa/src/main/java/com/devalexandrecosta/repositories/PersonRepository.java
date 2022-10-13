package com.devalexandrecosta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devalexandrecosta.model.Person;

public interface PersonRepository  extends JpaRepository<Person, Long>{}
