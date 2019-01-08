package com.example.CarApp.web;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.CarApp.domain.Car;
import com.example.CarApp.domain.CarRepository;

@RestController
public class CarController {
	
    @Autowired
    private CarRepository repository;
 
	@RequestMapping("/cars")
	public Iterable<Car> getCars() {
		return repository.findAll();
  } 
}
