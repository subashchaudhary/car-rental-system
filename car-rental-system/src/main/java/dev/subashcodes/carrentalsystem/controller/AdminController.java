package dev.subashcodes.carrentalsystem.controller;

import dev.subashcodes.carrentalsystem.exception.InvalidDataException;
import dev.subashcodes.carrentalsystem.model.Cars;
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
    public String add(@RequestBody Cars car){

        System.out.print(car.toString());
       //pass the car to service layer
        String response = null;
        try {
            response = carService.addNewCar(car);
        } catch (InvalidDataException e) {

           String message =  e.getMessage();
           return message;
        }

        return response;
    }

    @PutMapping("/car/update/{carId}")
    public String update(@PathVariable("carId") Integer id, @RequestBody Cars car){

        System.out.print("Incomming request to update car details for car id: " + id);
        String response = null;
        try{
            response = carService.updateCarDetails(id, car);
        }catch (InvalidDataException e){
            String message = e.getMessage();
            return message;
        }

        return response;
    }

    @PatchMapping("/car/patch/{carId}")
    public String patch(@PathVariable("carId") Integer id, @RequestBody Cars car){
        System.out.print("Incomming request to update car details for car id: " + id);
        String response = null;
        try{
            response = carService.patchCarDetails(id, car);
        }catch (InvalidDataException e){
            String message = e.getMessage();
            return message;
        }

        return response;
    }

    @GetMapping("/cars")
    public List<Cars> getAllCars(){
        System.out.println("Incoming request to get all cars");
        List<Cars> cars = carService.getAllCars();
        return cars;

    }

    @GetMapping("/car/{carId}")
    public Cars getCarById(@PathVariable("carId") Integer id){
         System.out.println("Incoming request to get car details for car id: " + id);
         Cars response = null;
         try {
             response = carService.getCarById(id);
         } catch (InvalidDataException e) {
             String message = e.getMessage();

         }
        return response;
    }


    @DeleteMapping("/car/delete/{carId}")
    public String delete(@PathVariable("carId") Integer id){
            System.out.println("Incoming request to delete car details for car id: " + id);
            String response = null;
            try {
                response = carService.deleteCarById(id);
            } catch (InvalidDataException e) {
                String message = e.getMessage();
                return message;
            }
            return response;
    }

    @GetMapping("/cars/brand")
    public List<Cars> getAllCarsByBrandName(@RequestParam("brandName") String brandName){
        System.out.println("Incoming request to get all cars by brand name: " + brandName);
        List<Cars> cars = carService.getAllCarByBrandName(brandName);
        return cars;
    }
}
