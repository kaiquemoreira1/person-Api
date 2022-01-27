package com.dio.personApi.dto;

import com.dio.personApi.enums.PhoneType;
import com.dio.personApi.validator.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Phone
public class PhoneDto {
    private PhoneType type;

    private String number;
}
