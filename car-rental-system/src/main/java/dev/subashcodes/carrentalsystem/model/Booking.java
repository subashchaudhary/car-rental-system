package dev.subashcodes.carrentalsystem.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("bookings")

@Getter
@Setter
public class Booking {

    private int id;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String licenseNumber;
    private int carId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int totalDays;
    private double totalCost;

}
