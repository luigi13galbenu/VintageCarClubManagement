package com.VintageCarClub.management.models.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Integer year;

    @ManyToMany(mappedBy = "cars")
    private Set<Member> owners = new HashSet<>();


    public Car() {
    }


    public Car(String make, String model, Integer year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Set<Member> getOwners() {
        return owners;
    }

    public void setOwners(Set<Member> owners) {
        this.owners = owners;
    }
}
