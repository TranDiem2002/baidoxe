package com.nhathongminh.nhathongminh.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "thue")
public class thuetheothang {

    @Id
    @GeneratedValue
    private  int id;

    @ManyToOne
    private CarEntity car;

    @Column(name = "price")
    private int price;
}
