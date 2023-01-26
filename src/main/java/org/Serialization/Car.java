package org.Serialization;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Car {
    private String model = "";
    private int year = 0;
    public Car(String model, int year){
        this.model = model;
        this.year = year;
    }
    public Car(){
    }
    public int getYear(){
        return this.year;
    }
    public String getModel(){
        return this.model;
    }
    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }

        if (!(o instanceof Car)) {
            return false;
        }

        Car c = (Car) o;

        return this.year == c.year && this.model.equals(c.model);
    }
}
