package com.dio.personApi.service;

import com.dio.personApi.dto.PersonDto;
import com.dio.personApi.entity.Person;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public Link save(PersonDto personDto) {
        return null;
    }
}
