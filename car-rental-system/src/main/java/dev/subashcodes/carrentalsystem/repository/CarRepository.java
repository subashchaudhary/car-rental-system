package dev.subashcodes.carrentalsystem.repository;

import dev.subashcodes.carrentalsystem.model.Cars;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  //tells spring to crate bean
public interface CarRepository extends MongoRepository<Cars, Integer> {


    //All Method Queries should defined here.

    @Query("{'brandName': ?0}") //this is a mongodb query, this will return all the cars which are available for rent.
    List<Cars> findAllByBrandName(String brandName); //this will return all the cars which are available for rent.


    @Query("{'model': ?0}") //this is a mongodb query, this will return all the cars which are available for rent.
    List<Cars> findAllByModel(String model); //this will return all the cars
}
