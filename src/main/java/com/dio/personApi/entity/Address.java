package com.dio.personApi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Column(name = "street",nullable = false)
    private String street;
    @Column(name = "number",nullable = false)
    private int number;
    @Column(name = "complement",nullable = false)
    private String complement;
    @Column(name = "country",nullable = false)
    private String country;
    @Column(name = "city",nullable = false)
    private String city;
    @Column(name = "state",nullable = false)
    private String state;
    @Column(name = "postal_code",nullable = false)
    private String postalCode;
}