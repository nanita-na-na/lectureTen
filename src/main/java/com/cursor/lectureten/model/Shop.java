package com.cursor.lectureten.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Accessors(chain = true)
@Entity
@Data
public class Shop {
    @Id
    @GeneratedValue

    Long id;
    String name;
    String city;
    String street;
    int countOfEmployees;
    boolean haveSite;
}
