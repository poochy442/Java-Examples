package com.example.REST_api.controller;

import com.example.REST_api.adapter.DataAdapter;
import com.example.REST_api.data.DataClass;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

// Data controller, responsible for exposing the endpoints related to the Data
@RestController
@RequestMapping("/data")
public class DataController {

    private DataAdapter adapter; // Adapter for Data access

    // Constructor
    public DataController(){
        adapter = new DataAdapter();
    }

    // GET: api/data
    // Gets all data from the adapter and returns it
    @GetMapping
    public List<DataClass> getAllData(){
        return adapter.getAllData();
    }

    // GET: api/data/get
    // Gets the requested data from the adapter and returns it
    @GetMapping(path = "/get")
    public DataClass getData(@RequestParam(value = "id") int id){
        return adapter.getData(id);
    }

    // POST: api/data/add
    // Adds the passed data using the adapter and return whether or not it succeeded
    @PostMapping(path = "/add")
    public boolean addData(@RequestParam(value = "string") String string){
        return adapter.addData(string);
    }

    // PUT: api/data/update
    // Updates the data with the passed id to be equal to the passed data using the adapter
    @PutMapping(path = "/update")
    public boolean updateData(@RequestParam(value = "id") int id,
                              @RequestParam(value = "string") String string){
        return adapter.setData(id, string);
    }

    // DELETE: api/data/delete
    // Removes the data with the passed id using the adapter
    // TODO - Add security!
    @DeleteMapping(path = "/delete")
    public boolean removeData(@RequestParam(value = "id") int id){
        return adapter.removeData(id);
    }

}
