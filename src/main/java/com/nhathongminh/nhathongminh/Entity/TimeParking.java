package com.nhathongminh.nhathongminh.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "time")
public class TimeParking
{
    @Id
    @GeneratedValue
    private int idTime;

    private  String carId;

    private String slot;

    private String status;

    @Column(name = "login")
    private Date login;

    @Column(name = "logout")
    private Date logout;
}
