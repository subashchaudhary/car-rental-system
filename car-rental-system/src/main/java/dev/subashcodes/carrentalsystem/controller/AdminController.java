package dev.subashcodes.carrentalsystem.controller;

import dev.subashcodes.carrentalsystem.model.Car;
import dev.subashcodes.carrentalsystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CarService carService;


    @PostMapping("/car/add")
    public String add(@RequestBody Car car){

        System.out.print(car.toString());
       //pass the car to service layer

        String response = carService.addNewCar(car);

        return car.toString();
    }

    @PutMapping("/car/update")
    public String update(){
        return "Updated Successfully";
    }

    @GetMapping("/cars")
    public String getAllCars(){
        return List.of().toString();
    }

    @GetMapping("/car/123")
    public String getCarById(){
        return "Car 123";
    }


    @DeleteMapping("/car/delete")
    public String delete(){
        return "Deleted Successfully";
    }
}
