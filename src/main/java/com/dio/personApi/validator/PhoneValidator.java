package com.dio.personApi.validator;

import com.dio.personApi.dto.PhoneDto;
import com.dio.personApi.enums.PhoneType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements
        ConstraintValidator<Phone, PhoneDto> {

    @Override
    public void initialize(Phone contactNumber) {
    }

    @Override
    public boolean isValid(PhoneDto phone, ConstraintValidatorContext context) {
        if (isFixed(phone)){
            return validation(phone, 8, 13);

        } else if(isMobile(phone)) {
            return validation(phone, 9, 14);
        }else
            return false;
    }

    private boolean validation(PhoneDto phone, int x, int x1) {
        return phone.getNumber() != null && phone.getNumber().matches("[0-9]+")
                && (phone.getNumber().length() > x) && (phone.getNumber().length() < x1);
    }

    private boolean  isMobile(PhoneDto phone){
        return phone.getType().equals(PhoneType.MOBILE);
    }
    private boolean isFixed(PhoneDto phone){
        return phone.getType().equals(PhoneType.HOME) || phone.getType().equals(PhoneType.COMMERCIAL);
    }

}