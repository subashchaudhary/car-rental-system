package dev.subashcodes.carrentalsystem.repository;

import dev.subashcodes.carrentalsystem.model.Cars;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository  //tells spring to crate bean
public interface CarRepository extends MongoRepository<Cars, Integer> {
}
