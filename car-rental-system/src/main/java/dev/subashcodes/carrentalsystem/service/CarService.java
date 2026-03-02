package dev.subashcodes.carrentalsystem.service;

import dev.subashcodes.carrentalsystem.exception.InvalidDataException;
import dev.subashcodes.carrentalsystem.model.Cars;
import dev.subashcodes.carrentalsystem.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service // spring will create a bean
public class CarService {

    @Autowired
    CarRepository carRepository;

    public String addNewCar (Cars car) throws InvalidDataException {

       // 1. validate the input data.
        if(car == null){
            throw new InvalidDataException("Invalid Car Details");
        }
        if(car.getName().isEmpty()){
            throw new InvalidDataException("Car Name is Required");
        }else if(car.getModel().isEmpty()){
            throw new InvalidDataException("Car's model is Required");
        }else if(car.getBrandName().isEmpty()){
            throw new InvalidDataException("Car Brand Name is Request");
        }else if(car.getNumberPlate().isEmpty()){
            throw  new InvalidDataException("Number plate is Required");
        }

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