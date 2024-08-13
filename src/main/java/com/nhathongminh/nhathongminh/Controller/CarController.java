package com.nhathongminh.nhathongminh.Controller;

import com.nhathongminh.nhathongminh.Entity.Car;
import com.nhathongminh.nhathongminh.Entity.CarEntity;
import com.nhathongminh.nhathongminh.Entity.CarModel;
import com.nhathongminh.nhathongminh.Entity.SlotModel;
import com.nhathongminh.nhathongminh.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/home")
    public String getHome(){
        return "home";
    }



    @GetMapping("/car")
    public String getCar(Model model){
        List<CarEntity> cars = carService.getAllCar();
        model.addAttribute("cars", cars);
        return "car";
    }

    @GetMapping("/car/add")
    public String createCarForm(Model model) {
        CarEntity car = new CarEntity();
        model.addAttribute("car", car);
        return "create_car";
    }

    @PostMapping("/car")
    public String addCar(@ModelAttribute("car") CarEntity car){
        CarEntity carEntity = carService.saveCar(car);
        return "redirect:/car";
    }

    @GetMapping("/car/edit/{id}")
    public String editStudentForm(@PathVariable String id, Model model) {
        model.addAttribute("car", carService.findByCarID(id));
        return "edit_car";
    }

    @PostMapping("/carUpdate/{id}")
    public String updateStudent(@PathVariable String id,
                                @ModelAttribute("car")CarEntity car,
                                Model model) {
        CarEntity carEntity = carService.updateCar(id, car);
        return "redirect:/car";
    }

    @GetMapping("/car/delete/{id}")
    public String updateStudent(@PathVariable String id) {
            carService.deleteCar(id);
        return "redirect:/car";
    }

    @GetMapping("/baido")
    public String getBaiDo(Model model){
        List<SlotModel> slotModels = carService.getCarParking();
        model.addAttribute("slots", slotModels);
        return "baido";
    }

    @GetMapping("/carParking")
    public String getXeBaiDo(Model model){
        List<Car> carModels = carService.getCarParked();
        model.addAttribute("cars", carModels);
        return "quanly";
    }
}
