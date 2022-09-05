package com.example.basebackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Student {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String firstName;
   private String lastName;
   private String email;

   // OWNING SIDE
   @OneToOne
   @JoinColumn(name = "passport_id", referencedColumnName = "id")
   private Passport passport;


   @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<Car> cars = new ArrayList<>();

   // Passport
   public void addPassport(Passport passport) {
      this.setPassport(passport);
   }

   // CARS
   public void addCar(Car car) {
      this.getCars().add(car);
      car.setStudent(this);
   }

   public void removeCar(Car car) {
      this.getCars().remove(car);
      car.setStudent(null);
   }

}
