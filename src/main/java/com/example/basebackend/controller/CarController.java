package com.example.basebackend.controller;

import com.example.basebackend.payload.request.CarRequest;
import com.example.basebackend.payload.request.PassportRequest;
import com.example.basebackend.payload.response.CarResponse;
import com.example.basebackend.payload.response.PassportResponse;
import com.example.basebackend.payload.response.StudentResponse;
import com.example.basebackend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CarController {

   // SERVICES
   @Autowired
   private CarService carService;

   @GetMapping("/api/students/{studentId}/cars/")
   public List<CarResponse> getAllCars(@PathVariable Long studentId) {
      return carService.getAllCars(studentId);
   }

   @PostMapping("/api/students/{studentId}/cars/")
   public CarResponse createCar(@PathVariable Long studentId, @Valid @RequestBody CarRequest carRequest) {
      return carService.createCar(studentId, carRequest);
   }

   @PatchMapping("/api/cars/{carId}/")
   public CarResponse updateCar(@PathVariable Long carId, @Valid @RequestBody CarRequest carRequest) {
      return carService.updateCar(carId, carRequest);
   }

   @DeleteMapping("/api/cars/{carId}/")
   public String deleteCar(@PathVariable Long carId) {
      return carService.deleteCar(carId);
   }
}
