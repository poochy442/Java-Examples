package com.example.REST_api.adapter;

import com.example.REST_api.data.DataClass;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// Data Adapter, responsible for data interaction and persistence
public class DataAdapter {

    List<DataClass> data; // Used to store the data, should be replaced with a database
    AtomicInteger counter; // Used to create ids

    // Constructor
    public DataAdapter(){
        data = new ArrayList<>();
        counter = new AtomicInteger(getCurrentId()); // Initiate the AtomicInteger to start

        // Add mock data
        data.add(new DataClass(counter.incrementAndGet(), "Hello"));
        data.add(new DataClass(counter.incrementAndGet(), "World"));
        data.add(new DataClass(counter.incrementAndGet(), "!"));
    }

    /* CRUD methods. These should be implemented to contact the database */
    // CREATE method - Return true if successfully added, false if not
    public boolean addData(String string){
        try{
            data.add(new DataClass(counter.incrementAndGet(), string));
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    // READ method - returns the requested item, null if the item is not found
    public DataClass getData(int id){
        for(DataClass d : data){
            if(d.getId() == id){
                return d;
            }
        }
        return null;
    }

    // READ method - returns the stored List of data
    public List<DataClass> getAllData(){
        return data;
    }

    // UPDATE method - Returns true if the item was updated, false if the item isn't found
    public boolean setData(int id, String string){
        for(DataClass d : data){
            if(d.getId() == id){
                d.setString(string);
                return true;
            }
        }
        return false;
    }

    // DELETE method - Returns true if the item was deleted, false if the item isn't found
    public boolean removeData(int id){
        for(DataClass d : data){
            if(d.getId() == id){
                data.remove(d);
                return true;
            }
        }
        return false;
    }

    /* Utility methods */
    // Returns the current max id
    public int getCurrentId(){
        // If the list is empty, return 0
        if(data.size() == 0)
            return 0;

        int maxId = 0;

        for(DataClass d : data){
            int currentId = d.getId();

            if(currentId > maxId){
                maxId = currentId;
            }
        }

        return maxId;
    }

}
