package org.Serialization;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class DriverTest {
    /*    public static void main(String[] args){
            Serialization serialization1 = new Serialization();
            Car carInstanceForSerialization = new Car("BMW", 1995);
        }*/
    @Test
    public void serialization() {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Car("BMW", 1995));
        vehicles.add(new Car("Mercedes", 1996));
        vehicles.add(new Motorcycle("Harley", 2023, 11.0));
        vehicles.add(new Car("Ford", 2003));
        vehicles.add(new Motorcycle("Honda", 2015, 8.5));
        for (Vehicle vehicle : vehicles) {
            vehicle.serializeToCsv("car.csv");
        }
        List<Vehicle> vehiclesDeserialized = new ArrayList<Vehicle>();
        for (Vehicle vehicle : vehicles) {
            vehiclesDeserialized.add(vehicle.deserializeFromCSV("car.csv"));
        }
        for (int i = 0; i < vehicles.size(); i++) {
            assertEquals(vehicles.get(i), vehiclesDeserialized.get(i));
        }
    }
}
