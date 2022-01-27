package com.dio.personApi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {
    @NotEmpty
    @Size(min = 2, max = 100)
    private String street;
    @NotNull
    private int number;
    @NotEmpty
    @Size(min = 1, max = 50)
    private String complement;
    @NotEmpty
    @Size(min = 2, max = 50)
    private String country;
    @NotEmpty
    @Size(min = 2, max = 50)
    private String city;
    @NotEmpty
    @Size(min = 2, max = 50)
    private String state;
    @NotEmpty
    @Size(min = 8, max = 8)
    private String postalCode;
}
