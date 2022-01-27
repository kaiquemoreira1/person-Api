package com.dio.personApi.service;

import com.dio.personApi.dto.PersonDto;
import com.dio.personApi.dto.mappers.PersonMapper;
import com.dio.personApi.entity.Person;
import com.dio.personApi.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;

import static com.dio.personApi.controller.PersonControllerTest.PERSON_API_URL_PATH;
import static com.dio.personApi.utils.factory.person;
import static com.dio.personApi.utils.factory.personDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonServiceImpl personService;

    @Test
    void givenPersonDtoThenReturnALinkToSavedPerson(){
        PersonDto personDto = personDto();
        Person person = person();

        when(personMapper.toModel(personDto)).thenReturn(person);
        when(personRepository.save(person)).thenReturn(person);

        Link expectedLink  = Link.of(PERSON_API_URL_PATH + "/" +person.getId()).withRel(IanaLinkRelations.ABOUT);
        Link link = personService.save(personDto);

        assertEquals(expectedLink.getHref(),link.getHref());
    }
}
