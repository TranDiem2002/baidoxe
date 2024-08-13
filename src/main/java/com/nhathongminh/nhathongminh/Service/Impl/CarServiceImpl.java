package com.nhathongminh.nhathongminh.Service.Impl;

import com.nhathongminh.nhathongminh.Entity.*;
import com.nhathongminh.nhathongminh.Repository.CarRepository;
import com.nhathongminh.nhathongminh.Repository.Customers.CarCustomerRepository;
import com.nhathongminh.nhathongminh.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarCustomerRepository carCustomerRepository;

    @Override
    public CarEntity saveCar(CarEntity car) {
        CarEntity cars = carRepository.save(car);
        return cars;
    }

    @Override
    public CarEntity findByCarID(String carId) {
        return carCustomerRepository.findByCarId(carId);
    }

    @Override
    public List<CarEntity> getAllCar() {
        return carRepository.findAll();
    }

    @Override
    public CarEntity updateCar(String carID, CarEntity car) {
        return carCustomerRepository.updateCar(carID, car);
    }

    @Override
    public void deleteCar(String carID) {
        carRepository.delete(carCustomerRepository.findByCarId(carID));
    }

    @Override
    public List<SlotModel> getCarParking() {
        List<String> slot = carCustomerRepository.getCarParking();
        List<SlotModel> slotModels = new ArrayList<>();
        for(int i =1; i<5; i++){
            String j = String.valueOf(i);
            if(slot.contains(j)){
                SlotModel slot1 = new SlotModel();
                List<CarEntity> carEntity = carCustomerRepository.getCarSlot(j);
                slot1.setVitri(j);
                slot1.setTrangthai("Đã có xe");
                slot1.setCar(carEntity.get(0).toString());
                slotModels.add(slot1);
            }
            else {
                SlotModel slot1 = new SlotModel();
                slot1.setVitri(j);
                slot1.setTrangthai("Trống");
                slotModels.add(slot1);
            }
        }
        return slotModels;
    }

    @Override
    public List<Car> getCarParked() {
        List<TimeParking> time = carCustomerRepository.getCarParked();
        List<Car> cars = new ArrayList<>();
        for(TimeParking car: time){
            Car car1 = new Car();
            CarEntity carEntity = carCustomerRepository.findByCarId(car.getCarId());
            car1.setCarId(car.getCarId());
            car1.setSlot(car.getSlot());
            car1.setLogin(car.getLogin());
            car1.setLogout(car.getLogout());
            car1.setStatus(car.getStatus());
            car1.setBien(carEntity.getBien());
            car1.setHang(carEntity.getHang());
            car1.setColor(carEntity.getColor());
            cars.add(car1);
        }
        return cars;
    }
}
