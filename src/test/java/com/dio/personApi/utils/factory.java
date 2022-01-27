package com.dio.personApi.utils;

import com.dio.personApi.dto.AddressDto;
import com.dio.personApi.dto.PersonDto;
import com.dio.personApi.dto.PhoneDto;
import com.dio.personApi.entity.Address;
import com.dio.personApi.entity.Person;
import com.dio.personApi.entity.Phone;
import com.dio.personApi.enums.PhoneType;

import java.util.Collections;
import java.util.Date;

public class factory {
    
    public static PersonDto personDto() {
        return PersonDto.builder()
                .firstName("Kaique")
                .lastName("Moreira")
                .cpf("50360235875")
                .address(addressDto())
                .birthDate(new Date())
                .phones(Collections.singletonList(phoneDto()))
                .build();

    }

    private static PhoneDto phoneDto() {
        return PhoneDto.builder()
                .type(PhoneType.MOBILE)
                .number("11983494049")
                .build();
    }

    private static AddressDto addressDto() {
        return AddressDto.builder()
                .street("Rua felipe de moura  ")
                .number(5)
                .complement("B")
                .country("Brazil")
                .state("São Paulo")
                .city("São Paulo")
                .postalCode("08340430")
                .build();
    }

    public static Person person() {
        return Person.builder()
                .id(1L)
                .firstName("Kaique")
                .lastName("Moreira")
                .cpf("50360235875")
                .address(address())
                .birthDate(new Date())
                .phones(Collections.singletonList(phone()))
                .build();
    }

    private static Phone phone() {
        return Phone.builder()
                .id(1L)
                .type(PhoneType.COMMERCIAL)
                .number("11983494049")
                .build();
    }

    private static Address address() {
        return Address.builder()
                .street("Rua felipe de moura  ")
                .number(5)
                .complement("B")
                .country("Brazil")
                .state("São Paulo")
                .city("São Paulo")
                .postalCode("08340430")
                .build();
    }
}
