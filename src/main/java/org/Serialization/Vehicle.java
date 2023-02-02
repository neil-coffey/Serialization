package org.Serialization;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

public interface Vehicle {
    public void serializeToCsv(String fileName);

    public Vehicle deserializeFromCSV(String fileName);

    public String prettyPrintToCSV();
}
