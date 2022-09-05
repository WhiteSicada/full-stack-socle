package com.example.basebackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

   public void addPassport(Passport passport) {
      this.setPassport(passport);
   }

}
