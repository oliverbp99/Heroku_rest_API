package com.example.heroku_rest_api.controller;

import com.example.heroku_rest_api.model.Car;
import com.example.heroku_rest_api.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Cars {

    @Autowired
    CarsRepository cars;

    @GetMapping("/cars")
    public Iterable<Car> getCars(){
        return cars.findAll();
    }

    @GetMapping("cars/{id}")
    public Car getCar(@PathVariable Long id){
        return cars.findById(id).get();
    }

    @PostMapping("/cars")
    public Car addCar(@RequestBody Car newCar){
        newCar.setId(null);
        return cars.save(newCar);
    }

    @PutMapping("/cars/{id}")
    public String updateCarById(@PathVariable Long id, @RequestBody Car carToUpdateWith){
        return cars.findById(id).map(foundCar -> {
            foundCar.setBrand(carToUpdateWith.getBrand());
            foundCar.setType(carToUpdateWith.getType());
            foundCar.setModel(carToUpdateWith.getModel());
            foundCar.setDoors(carToUpdateWith.getDoors());
            foundCar.setRegistrationNumber(carToUpdateWith.getRegistrationNumber());

            cars.save(foundCar);
            return "found car";
        }).orElse("Car not found");
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCarById(@PathVariable Long id){
        cars.deleteById(id);
    }
}
