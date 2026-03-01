package dev.subashcodes.carrentalsystem.service;

import dev.subashcodes.carrentalsystem.model.Car;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service // spring will create a bean
public class CarService {


    public String addNewCar(Car car){

        //TO-D0: logic to add new car to our system.

       // 1. validate the input data.


        //2. Insert in to our database


        //3. if insert is successful then return success message or return
        // error message or throw exception


        return  null;
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