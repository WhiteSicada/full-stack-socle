package com.example.basebackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
@NoArgsConstructor
public class Passport {
   @Id
   private int id;

   private String number;

   @OneToOne(mappedBy = "passport")
   private Student student;

}
