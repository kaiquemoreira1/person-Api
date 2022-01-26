package com.dio.personApi.dto;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto extends RepresentationModel<PersonDto> {
    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;
    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;
    @NotEmpty
    @CPF
    private String cpf;
    @Valid
    @NotEmpty
    private AddressDto address;
    @NotNull
    private Date birthDate;
    @Valid
    @NotEmpty
    private List<PhoneDto> phones;
}

