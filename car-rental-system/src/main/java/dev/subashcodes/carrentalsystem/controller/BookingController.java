package dev.subashcodes.carrentalsystem.controller;

import dev.subashcodes.carrentalsystem.model.Booking;
import dev.subashcodes.carrentalsystem.model.Cars;
import dev.subashcodes.carrentalsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {


    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public Booking bookCar(@RequestBody Booking booking) {
        System.out.println("Booking a car...");

        Booking bookingResponse = null;
        try{
           bookingResponse =  bookingService.bookCar(booking);
        }catch (Exception e){
            String message = e.getMessage();
            //return message;
        }



       return bookingResponse;
    }

    @PostMapping("/cancel")
    public String cancelCar() {
       return  "Car cancelled successfully!";
    }

    @PostMapping("/return")
    public String returnCar() {
        return "Car returned successfully!";
    }
}
