package com.nhathongminh.nhathongminh.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")
public class CarEntity {

    @Id
    private String carId;

    @Column(name = "bien")
    private String bien;

    @Column(name = "hang")
    private String hang;

    @Column(name = "color")
    private String color;

    @Override
    public String toString() {
        return "CarEntity{" +
                "carId='" + carId + '\'' +
                ", bien='" + bien + '\'' +
                ", hang='" + hang + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
