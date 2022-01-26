package com.dio.personApi.controller;

import com.dio.personApi.dto.AddressDto;
import com.dio.personApi.dto.PersonDto;
import com.dio.personApi.dto.PhoneDto;
import com.dio.personApi.entity.Address;
import com.dio.personApi.entity.Person;
import com.dio.personApi.entity.Phone;
import com.dio.personApi.enums.PhoneType;
import com.dio.personApi.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Collections;
import java.util.Date;

import static com.dio.personApi.utils.JsonConversionUtils.asJsonString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class PersonControllerTest {
    private static final String PERSON_API_URL_PATH = "/api/v1/people";
    private MockMvc mockMvc;

    @InjectMocks
    PersonController personController;
    @Mock
    private PersonService personService;

    @BeforeEach
    void setup(){

        mockMvc = MockMvcBuilders.standaloneSetup(personController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((viewName, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void whenPOSTIsCalledThenAPersonShouldBeCreated() throws Exception {
        PersonDto personDto = createFakeDto();
        when(personService.save(personDto)).thenReturn(Link.of(PERSON_API_URL_PATH + "/" +1));
        mockMvc.perform(post(PERSON_API_URL_PATH)
                .content(asJsonString(personDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    private PersonDto createFakeDto(){
        return PersonDto.builder()
                .firstName("Kaique")
                .lastName("Moreira")
                .cpf("50360235875")
                .address(AddressDto.builder()
                        .street("Rua felipe de moura  ")
                        .number(5)
                        .complement("B")
                        .country("Brazil")
                        .state("São Paulo")
                        .city("São Paulo")
                        .postalCode("08340430")
                        .build())
                .birthDate(new Date())
                .phones(Collections.singletonList(PhoneDto.builder()
                        .type(PhoneType.COMMERCIAL)
                        .number("11983494049")
                        .build()))
                .build();

    }
    private Person createFakeEntity(){
        return Person.builder()
                .firstName("Kaique")
                .lastName("Moreira")
                .cpf("50360235875")
                .address(Address.builder()
                        .street("Rua felipe de moura  ")
                        .number(5)
                        .complement("B")
                        .country("Brazil")
                        .state("São Paulo")
                        .city("São Paulo")
                        .postalCode("08340430")
                        .build())
                .birthDate(new Date())
                .phones(Collections.singletonList(Phone.builder()
                        .type(PhoneType.COMMERCIAL)
                        .number("11983494049")
                        .build()))
                .build();
    }
}
