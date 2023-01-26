package org.Serialization;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DriverTest {
    /*    public static void main(String[] args){
            Serialization serialization1 = new Serialization();
            Car carInstanceForSerialization = new Car("BMW", 1995);
        }*/
    @Test
    public void serialization() {
        Car carInstanceForSerialization = new Car("BMW", 1995);
        Serialization.serializeToCsv(carInstanceForSerialization, "car.csv");
        assertEquals(Serialization.deserializeFromCSV("car.csv"), carInstanceForSerialization);
    }
}
