package dev.subashcodes.carrentalsystem.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Document("cars") //this tells this is not a normal java calls, but mongodb collections.
public class Cars {

    private int id;
    private String name;
    private String model;
    private String brandName;
    private String numberPlate;
    private boolean isAvailable;
    private float pricePerDay;


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", brandName='" + brandName + '\'' +
                ", numberPlate='" + numberPlate + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
