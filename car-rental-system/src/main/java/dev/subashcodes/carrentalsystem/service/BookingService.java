package dev.subashcodes.carrentalsystem.service;

import dev.subashcodes.carrentalsystem.exception.InvalidDataException;
import dev.subashcodes.carrentalsystem.model.Booking;
import dev.subashcodes.carrentalsystem.model.Cars;
import dev.subashcodes.carrentalsystem.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CarService carService;

    public Booking bookCar(Booking booking) throws InvalidDataException {
        // Logic to book a car for a customer

        Integer carId = booking.getCarId();

        //check if the car is available for booking
        try {

          Cars car = carService.getCarById(carId);
            if(car == null){
                throw new InvalidDataException("Car Not Found");
            }else if (!car.isAvailable()) {
              throw new InvalidDataException("Car is not available");
            }else{

                //logic to book the car and update the availability status

                //user details valida
                String customerName = booking.getCustomerName();
                if(customerName == null || customerName.isEmpty()){
                    throw new InvalidDataException("Customer name is required");
                }
                String phone = booking.getCustomerPhone();
                if(phone == null || phone.isEmpty()){
                    throw new InvalidDataException("Customer phone number is required");
                }

                String licenseNumber = booking.getLicenseNumber();
                if(licenseNumber == null || licenseNumber.isEmpty()){
                    throw new InvalidDataException("Customer license number is required");
                }
                int noOfDays = booking.getTotalDays();
                if(noOfDays <= 0){
                    throw new InvalidDataException("Total days must be greater than zero");
                }

                // start date
                LocalDateTime startDate = LocalDateTime.now();
                LocalDateTime endDate = startDate.plusDays(noOfDays);

                //setting start and end date
                booking.setStartDate(startDate);
                booking.setEndDate(endDate);

                // calculate total cost
                double totalCost = noOfDays * car.getPricePerDay();
                booking.setTotalCost(totalCost);

                //new booking id
                Integer id = new Random().nextInt(10000);
                booking.setId(id);
                bookingRepository.save(booking);
                //update the availability status of the car
                car.setAvailable(false);
                carService.updateCarDetails(carId, car);

                return booking;
            }

        }catch(Exception e){
            throw e;
        }
    }
}
