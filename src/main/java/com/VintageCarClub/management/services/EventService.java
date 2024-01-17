package com.VintageCarClub.management.services;

import com.VintageCarClub.management.exceptions.ResourceNotFoundException;
import com.VintageCarClub.management.models.entities.Event;
import com.VintageCarClub.management.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> findEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Event saveEvent(Event event) {
        validateEvent(event);
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event event) {
        validateEvent(event);
        if (!eventRepository.existsById(id)) {
            throw new ResourceNotFoundException("Event not found with id " + id);
        }
        event.setId(id);
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new ResourceNotFoundException("Event not found with id " + id);
        }
        eventRepository.deleteById(id);
    }

    private void validateEvent(Event event) {
        if (event == null || !StringUtils.hasText(event.getName()) || event.getDate() == null || !StringUtils.hasText(event.getLocation())) {
            throw new IllegalArgumentException("Event name, date, and location must not be empty");
        }
    }
}
