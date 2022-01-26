package com.dio.personApi.controller;

import com.dio.personApi.dto.PersonDto;
import com.dio.personApi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Link post(@RequestBody PersonDto personDto){
        return personService.save(personDto);
    }

    public PersonDto get(Long id) {
        return new PersonDto();
    }
}
