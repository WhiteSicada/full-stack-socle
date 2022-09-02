package com.example.basebackend.model;

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
   @JoinColumn(name = "passport_id")
   private Passport passport;

}
