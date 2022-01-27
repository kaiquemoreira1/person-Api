package com.dio.personApi.controller;

import com.dio.personApi.dto.PersonDto;
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

import static com.dio.personApi.utils.JsonConversionUtils.asJsonString;
import static com.dio.personApi.utils.factory.personDto;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class PersonControllerTest {
    public static final String PERSON_API_URL_PATH = "/api/v1/people";
    private MockMvc mockMvc;

    @InjectMocks
    PersonController personController;
    @Mock
    private PersonService personService;

    @BeforeEach
    void setup() {

        mockMvc = MockMvcBuilders.standaloneSetup(personController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((viewName, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void whenPOSTIsCalledThenAPersonShouldBeCreated() throws Exception {
        PersonDto personDto = personDto();
        when(personService.save(personDto)).thenReturn(Link.of(PERSON_API_URL_PATH + "/" +1));
        mockMvc.perform(post(PERSON_API_URL_PATH)
                        .content(asJsonString(personDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}
