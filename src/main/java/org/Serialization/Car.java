package org.Serialization;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

public class Car implements Vehicle {
    private String model;
    private int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public Car() {
        this.model = model = "";
        this.year = 0;
    }

    public int getYear() {
        return this.year;
    }

    public String getModel() {
        return this.model;
    }

    public void serializeToCsv(String fileName) {
        String writeData = this.prettyPrintToCSV();
        try {
            Files.write(Paths.get(fileName), writeData.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ;

    @Override
    public Vehicle deserializeFromCSV(String fileName) {
        Car returnCar = new Car();
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                if (line.trim().equals("")) {
                    continue;
                } else {
                    String[] carAttributesArray = line.trim().split(Pattern.quote(","));
                    returnCar = new Car(carAttributesArray[0].trim(), Integer.parseInt(carAttributesArray[1].trim()));
                    lines.remove(line);
                    StringBuilder writeString = new StringBuilder();
                    for (String writeLine : lines) {
                        writeString.append(writeLine + "\n");
                    }
                    Files.write(Paths.get(fileName), writeString.toString().getBytes());
                    return returnCar;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnCar;
    }

    ;

    @Override
    public String prettyPrintToCSV() {
        String carModel = this.getModel();
        int carYear = this.getYear();
        String writeData = "\n" + carModel + "," + Integer.toString(carYear);
        return writeData;
    }

    ;

    @Override
    public boolean equals(Object o) {
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
