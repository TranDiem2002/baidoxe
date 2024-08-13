package com.nhathongminh.nhathongminh.Repository.Customers;

import com.nhathongminh.nhathongminh.Entity.CarEntity;
import com.nhathongminh.nhathongminh.Entity.CarModel;
import com.nhathongminh.nhathongminh.Entity.SlotModel;
import com.nhathongminh.nhathongminh.Entity.TimeParking;
import com.nhathongminh.nhathongminh.Repository.CarRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarCustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    public CarEntity findByCarId(String carId){
        StringBuilder sql = new StringBuilder("select * from car where car_id = :carId");
        Query query = entityManager.createNativeQuery(sql.toString(), CarEntity.class);
        query.setParameter("carId", carId);
        return (CarEntity) query.getResultList().get(0);
    }

    public CarEntity updateCar(String carId, CarEntity car){
        CarEntity carEntity = findByCarId(carId);
        carEntity.setBien(car.getBien());
        carEntity.setHang(car.getHang());
        carEntity.setColor(car.getColor());
        return carRepository.save(carEntity);
    }

    public List<String> getCarParking(){
        StringBuilder sql = new StringBuilder("select slot from time where status = 'Đỗ'");
        Query query = entityManager.createNativeQuery(sql.toString());
        return query.getResultList();
    }

    public List<CarEntity> getCarSlot(String slot){
        StringBuilder sql = new StringBuilder("select * from car where car_id in (select car_id from time where status = 'Đỗ' and slot = :slot)");
        Query query = entityManager.createNativeQuery(sql.toString(), CarEntity.class);
        query.setParameter("slot", slot);
        return  query.getResultList();
    }

    public List<TimeParking> getCarParked(){
        StringBuilder sql = new StringBuilder("select * from time order by login");
        Query query = entityManager.createNativeQuery(sql.toString(), TimeParking.class);
        return query.getResultList();
    }
}
