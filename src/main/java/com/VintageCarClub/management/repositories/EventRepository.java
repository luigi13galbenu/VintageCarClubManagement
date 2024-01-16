package com.VintageCarClub.management.repositories;

import com.VintageCarClub.management.models.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByName(String name);

    List<Event> findByDate(LocalDate date);

    List<Event> findByLocation(String location);
}