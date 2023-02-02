package org.Serialization;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

public class Motorcycle implements Vehicle {
    private String model;
    private int year;
    private double tankSize;

    public Motorcycle(String model, int year, double tankSize) {
        this.model = model;
        this.year = year;
        this.tankSize = tankSize;
    }

    public Motorcycle() {
        this.model = model = "";
        this.year = 0;
        this.tankSize = 0;
    }

    public int getYear() {
        return this.year;
    }

    public String getModel() {
        return this.model;
    }

    public double getTankSize() {
        return tankSize;
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
        Motorcycle returnMotorcycle = new Motorcycle();
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                if (line.trim().equals("")) {
                    continue;
                } else {
                    String[] MotorcycleAttributesArray = line.trim().split(Pattern.quote(","));
                    returnMotorcycle = new Motorcycle(MotorcycleAttributesArray[0].trim(),
                            Integer.parseInt(MotorcycleAttributesArray[1].trim()),
                            Double.parseDouble(MotorcycleAttributesArray[1].trim()));
                    lines.remove(line);
                    StringBuilder writeString = new StringBuilder();
                    for (String writeLine : lines) {
                        writeString.append(writeLine + "\n");
                    }
                    Files.write(Paths.get(fileName), writeString.toString().getBytes());
                    return returnMotorcycle;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnMotorcycle;
    }

    ;

    @Override
    public String prettyPrintToCSV() {
        String motorcycleModel = this.getModel();
        int motorcycleYear = this.getYear();
        double motorcycleTank = this.getTankSize();
        String writeData = "\n" + motorcycleModel + "," + Integer.toString(motorcycleYear) + "," +
                Double.toString(motorcycleTank);
        return writeData;
    }

    ;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Motorcycle)) {
            return false;
        }

        Motorcycle c = (Motorcycle) o;

        return this.year == c.year && this.model.equals(c.model);
    }
}
