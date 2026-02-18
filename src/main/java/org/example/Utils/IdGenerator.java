package org.example.Utils;

public class IdGenerator {
    private static int serialNumber = 0;
    public static String generateId(String type){
        serialNumber++;
        return type+String.valueOf(serialNumber);
    }
}
