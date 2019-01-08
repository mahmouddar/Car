package com.example.CarApp;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.CarApp.domain.Car;
import com.example.CarApp.domain.CarRepository;
import com.example.CarApp.domain.OwnerRepository;
import com.example.CarApp.domain.Trip;
import com.example.CarApp.domain.TripRepository;
import com.example.CarApp.domain.Owner;

@SpringBootApplication
public class CarAppApplication {

	@Autowired
	private CarRepository repository;
	@Autowired
	private OwnerRepository repository1;
	@Autowired
	private TripRepository repository2;
	
	public static void main(String[] args) {
		SpringApplication.run(CarAppApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			 // Add owner objects and save these to db
            Owner owner1 = new Owner("John" , "Johnson");
            Owner owner2 = new Owner("Mary" , "Robinson");
            repository1.save(owner1);
            repository1.save(owner2);

            
            // Add car object with link to owners and save these to db.
            Car car = new Car("Ford", "Mustang", "Red", 
                "ADF-1121", 2017, 59000, owner1);
            Set<Car> a = new HashSet<Car>();
            a.add(car);
            a.add(car);
            Trip trip = new Trip("trip1",a);
            repository.save(car);
            repository2.save(trip);
           
            car = new Car("Nissan", "Leaf", "White",
                "SSJ-3002", 2014, 29000, owner2);
            repository.save(car);
            
            car = new Car("Toyota", "Prius", "Silver",
                "KKO-0212", 2018, 39000, owner2);
            repository.save(car);
          
		};
	}
}
