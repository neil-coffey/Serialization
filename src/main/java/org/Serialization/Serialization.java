package org.Serialization;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Serialization {
    public Serialization(){

    }
    public static void serializeToCsv(Serialization classInstance, String fileName){

    }
    public static Serialization deserializeFromCSV(String fileName){
        return new Serialization();
    }
    public String prettyPrintToCSV(){return "";}
}
