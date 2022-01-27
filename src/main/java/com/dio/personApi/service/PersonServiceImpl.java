package com.dio.personApi.service;

import com.dio.personApi.controller.PersonController;
import com.dio.personApi.dto.PersonDto;
import com.dio.personApi.dto.mappers.PersonMapper;
import com.dio.personApi.entity.Person;
import com.dio.personApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonMapper personMapper;

    @Override
    public Link save(PersonDto personDto) {
        Person person = personMapper.toModel(personDto);
        personRepository.save(person);
        return linkTo(methodOn(PersonController.class).get(person.getId())).withRel(IanaLinkRelations.ABOUT);
    }
}
