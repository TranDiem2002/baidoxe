package com.nhathongminh.nhathongminh.Repository;

import com.nhathongminh.nhathongminh.Entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<CarEntity, Integer> {

}
