package com.VintageCarClub.management.models.entities;

import java.time.LocalDate;
import java.util.Set;

public class Event {

    private long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private Set<Member> participants;
    private Set<Car> carsDisplayed;

}
