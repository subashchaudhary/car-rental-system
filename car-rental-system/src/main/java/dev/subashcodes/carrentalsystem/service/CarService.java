package dev.subashcodes.carrentalsystem.service;

import dev.subashcodes.carrentalsystem.exception.InvalidDataException;
import dev.subashcodes.carrentalsystem.model.Cars;
import dev.subashcodes.carrentalsystem.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service // spring will create a bean
public class CarService {

    @Autowired
    CarRepository carRepository;

    public String addNewCar (Cars car) throws InvalidDataException {

       // 1. validate the input data.
       validateCarDetails(car);

        //2. Insert in to our database
        int newId = new Random().nextInt(10000);
        car.setId(newId);
        car.setAvailable(true);
        Cars savedCar =  carRepository.save(car);

        //3. if insert is successful then return success message or return
        // error message or throw exception

        if(savedCar == null){

            return "Car Not Saved";
        }else{
            return "Successfully Saved car details";
        }

    }

    public String patchCarDetails(Integer id, Cars car) throws InvalidDataException {
        //1. validate the input data

        //2. check if car with given id exist in database or not
        boolean isExist = carRepository.existsById(id);
        if (!isExist) {
            return "Car with id: " + id + " does not exist";
        }

        Optional<Cars> existingCarOpt = carRepository.findById(id);

        Cars existingCar = existingCarOpt.get();



        if (car.getName() != null && !car.getName().isEmpty()) {
            existingCar.setName(car.getName());
        }
        if (car.getModel() != null && !car.getModel().isEmpty()) {
            existingCar.setModel(car.getModel());
        }
        if (car.getBrandName() != null && !car.getBrandName().isEmpty()) {
            existingCar.setBrandName(car.getBrandName());
        }
        if (car.getNumberPlate() != null && !car.getNumberPlate().isEmpty()) {
            existingCar.setNumberPlate(car.getNumberPlate());
        }
        existingCar.setId(id);
        existingCar.setAvailable(car.isAvailable());
        //3. update the details of the car in database
        Cars updatedCar = carRepository.save(existingCar); //if already exist then it will update else it will create new entiry.

        //4. return success message or error message
        if (updatedCar == null) {
            return "Failed to update car details for car id: " + id;
        } else {
            return "Successfully updated car details for car id: " + id;
        }
    }

    public String updateCarDetails(Integer id, Cars car) throws InvalidDataException {
        //1. validate the input data
        validateCarDetails(car);

        //2. check if car with given id exist in database or not
        boolean isExist = carRepository.existsById(id);
        if (!isExist) {
            return "Car with id: " + id + " does not exist";
        }

        //3. update the details of the car in database
        Cars updatedCar = carRepository.save(car); //if already exist then it will update else it will create new entiry.

        //4. return success message or error message
        if (updatedCar == null) {
            return "Failed to update car details for car id: " + id;
        } else {
            return "Successfully updated car details for car id: " + id;
        }
    }


    private void validateCarDetails(Cars car) throws InvalidDataException {

        // validate the input data of car details.
        if (car == null) {
            throw new InvalidDataException("Invalid Car Details");
        }
        if (car.getName().isEmpty()) {
            throw new InvalidDataException("Car Name is Required");
        } else if (car.getModel().isEmpty()) {
            throw new InvalidDataException("Car's model is Required");
        } else if (car.getBrandName().isEmpty()) {
            throw new InvalidDataException("Car Brand Name is Request");
        } else if (car.getNumberPlate().isEmpty()) {
            throw new InvalidDataException("Number plate is Required");
        }
    }

    public List<Cars> getAllCars() {
        return carRepository.findAll(); // it will return list of all cars in database
    }

     public Cars getCarById(Integer id) throws InvalidDataException {
         boolean isExist = carRepository.existsById(id);
         if (!isExist) {
             throw new InvalidDataException("Car with id: " + id + " does not exist");
         }
         return carRepository.findById(id).get();
     }

     public String deleteCarById(Integer id) throws InvalidDataException {
         boolean isExist = carRepository.existsById(id);
         if (!isExist) {
             throw new InvalidDataException("Car with id: " + id + " does not exist");
         }
         carRepository.deleteById(id);
         return "Successfully deleted car details for car id: " + id;
     }

//     public Car getCarByNumberPlate(String numberPlate) throws InvalidDataException {
//         Cars car = carRepository.findByNumberPlate(numberPlate);
//         if (car == null) {
//             throw new InvalidDataException("Car with number plate: " + numberPlate + " does not exist");
//         }
//         return car;
//     }


     public List<Cars> getAllCarByBrandName(String brandName) {
         return carRepository.findAllByBrandName(brandName);
     }

}



/**
 *
 *
 * Database : 1. Relation database, 2. Nosql Database
 *
 * 1. Relation Database: Relation table in form of Row and cloumn as Table having fixed schema,
 * in form of table and data are stored in form of row wise also called tuple.
 *
 * 2. NoSQL is schema less datbase, stored data as documents in a collection
 */