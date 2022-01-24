package com.dio.personApi.entity;

import com.dio.personApi.enums.PhoneType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "phone_type",nullable = false)
    private PhoneType type;
    @Column(name = "phone_number",nullable = false)
    private String number;
}