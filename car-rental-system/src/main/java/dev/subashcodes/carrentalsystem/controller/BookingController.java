package dev.subashcodes.carrentalsystem.controller;

import dev.subashcodes.carrentalsystem.exception.InvalidDataException;
import dev.subashcodes.carrentalsystem.model.Booking;
import dev.subashcodes.carrentalsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/cancel/{bookingId}")
    public String cancelCar(@PathVariable("bookingId") Integer bookingId) {


        try {
            boolean isCanceled = bookingService.cancelCar(bookingId);
            if(!isCanceled){
                return "Failed to cancel the booking. Please try again.";
            }else{
                return "Car cancelled successfully!";
            }
        } catch (InvalidDataException e) {
            throw new RuntimeException(e);
        }

    }

    @PostMapping("/return")
    public String returnCar() {

        try{
            boolean isReturned = bookingService.returnCar(1);
            if(!isReturned){
                return "Failed to return the car. Please try again.";
            }else{
                return "Car returned successfully!";
            }
        }catch (InvalidDataException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/booking/{bookingId}")
    public Booking getBookingDetails(@PathVariable("bookingId") Integer bookingId) throws InvalidDataException {

       try {
              Booking booking = bookingService.getBookingById(bookingId);
              if (booking == null) {
                return null;
              } else {
                return booking;
              }
       }catch (Exception ex){
              throw ex;
       }
    }
    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
       try{
         return  bookingService.getAllBookings();
       }catch (Exception ex){
           throw ex;
       }
    }

    @DeleteMapping("/booking/{bookingId}")
    public String deleteBooking(@PathVariable("bookingId") Integer bookingId) throws Exception{

        try{
            boolean isDeleted = bookingService.deleteBooking(bookingId);
            if(!isDeleted){
                return "Failed to delete the booking. Please try again.";
            }else{
                return "Booking deleted successfully!";
            }
        }catch (Exception ex){
            throw ex;
        }
    }



}
