package com.VintageCarClub.management.models.entities;

import java.time.LocalDate;
import java.util.Set;

public class Member {

    private long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate joinDate;
    private Set<Car> carsOwned;
    private String membershipType;

}
