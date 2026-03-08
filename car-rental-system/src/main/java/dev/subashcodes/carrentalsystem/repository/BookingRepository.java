package dev.subashcodes.carrentalsystem.repository;

import dev.subashcodes.carrentalsystem.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends MongoRepository<Booking, Integer> {
}
