package com.nhathongminh.nhathongminh.Entity;

import com.nhathongminh.nhathongminh.Repository.CarRepository;
import com.nhathongminh.nhathongminh.Repository.Customers.CarCustomerRepository;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CarModel {

    ModelMapper modelMapper = new ModelMapper();


    public List<Car> convertTime(List<TimeParking> timeParkings){
        List<Car> cars = new ArrayList<>();
        for(TimeParking time: timeParkings){
            Car car = modelMapper.map(time, Car.class);
            cars.add(car);
        }

        return cars;
    }
}
