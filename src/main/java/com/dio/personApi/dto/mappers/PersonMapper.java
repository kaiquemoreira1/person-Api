package com.dio.personApi.dto.mappers;

import com.dio.personApi.dto.PersonDto;
import com.dio.personApi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "id", ignore = true)
    Person toModel(PersonDto dto);

    PersonDto toDTO(Person dto);
}
