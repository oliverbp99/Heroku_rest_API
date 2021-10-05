package com.example.heroku_rest_api.repository;

import com.example.heroku_rest_api.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Car, Long> {

}