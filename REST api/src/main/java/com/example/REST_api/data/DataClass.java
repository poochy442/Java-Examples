package com.example.REST_api.data;

// Data class used to store data about a part of the program.
public class DataClass {

    // Data to store
    private final int id;
    private String aString;

    // Constructor
    public DataClass(int id, String aString){
        this.id = id;
        this.aString = aString;
    }

    // Getter-Setter
    public int getId() {
        return id;
    }

    public String getString() {
        return aString;
    }

    public void setString(String aString) {
        this.aString = aString;
    }
}
