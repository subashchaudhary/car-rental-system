package dev.subashcodes.carrentalsystem.repository;

import dev.subashcodes.carrentalsystem.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {


}
