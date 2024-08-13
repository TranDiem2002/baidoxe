package com.nhathongminh.nhathongminh.Entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private String carId;

    private String slot;

    private String status;

    private Date login;

    private Date logout;

    private String bien;


    private String hang;

    private String color;
}
