package com.dio.personApi.controller;

import com.dio.personApi.dto.PersonDto;
import com.dio.personApi.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Link create(@Valid @RequestBody PersonDto personDto){
        System.out.println("teste");
        return personService.save(personDto);
    }
    @GetMapping("/{id}")
    public PersonDto get(@PathVariable Long id){
        return null;
    }
}
