package com.dio.personApi.dto;

import com.dio.personApi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneDto {
    @Enumerated(EnumType.STRING)
    private PhoneType type;
    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;
}
