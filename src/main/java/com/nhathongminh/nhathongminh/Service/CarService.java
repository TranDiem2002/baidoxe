package com.nhathongminh.nhathongminh.Service;

import com.nhathongminh.nhathongminh.Entity.Car;
import com.nhathongminh.nhathongminh.Entity.CarEntity;
import com.nhathongminh.nhathongminh.Entity.CarModel;
import com.nhathongminh.nhathongminh.Entity.SlotModel;

import java.util.List;
import java.util.Optional;

public interface CarService {

 CarEntity saveCar(CarEntity car);

CarEntity findByCarID(String carId);

 List<CarEntity> getAllCar();

 CarEntity updateCar(String carID, CarEntity car);

 void deleteCar(String carID);

 List<SlotModel> getCarParking();

 List<Car> getCarParked();


}
