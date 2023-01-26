package org.Serialization;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

public class Serialization {
    public Serialization(){

    }
    public static void serializeToCsv(Car classInstance, String fileName){
        String writeData = Serialization.prettyPrintToCSV(classInstance);
        try{
            Files.write(Paths.get(fileName), writeData.getBytes());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public static Car deserializeFromCSV(String fileName){
        Car returnCar  = new Car();
        try{
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line:lines){
                String carString = line.replace("\n", "");

                if (carString.equals("")){
                    continue;
                }

                String[] carAttributesArray = carString.split(Pattern.quote(","));
                try{
                    if (carAttributesArray.length != 2){
                        throw new Exception
                                ("Error, attribute count mismatch. Make sure there are only 2 attributes in CSV");
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
                returnCar = new Car(carAttributesArray[0], Integer.parseInt(carAttributesArray[1]));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return returnCar;
    }
    public static String prettyPrintToCSV(Car c){
        String carModel = c.getModel();
        int carYear = c.getYear();
        String writeData = carModel+","+Integer.toString(carYear);
        return writeData;
    }
}
