package com.dio.personApi.service;

import com.dio.personApi.dto.PersonDto;
import org.springframework.hateoas.Link;

public interface PersonService {
    Link save(PersonDto personDto);
}
