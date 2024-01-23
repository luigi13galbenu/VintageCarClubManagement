package com.VintageCarClub.management.services;

import com.VintageCarClub.management.models.dtos.EventRequestDto;
import com.VintageCarClub.management.models.dtos.EventResponseDto;
import com.VintageCarClub.management.models.entities.Event;
import com.VintageCarClub.management.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public EventResponseDto saveEvent(EventRequestDto eventDto) {
        Event event = new Event();
        event.setName(eventDto.getName());
        event.setDate(eventDto.getDate());
        event.setLocation(eventDto.getLocation());

        Event savedEvent = eventRepository.save(event);
        return convertToDto(savedEvent);
    }

    @Override
    public EventResponseDto findEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
        return convertToDto(event);
    }

    @Override
    public EventResponseDto updateEvent(Long id, EventRequestDto eventDto) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));

        existingEvent.setName(eventDto.getName());
        existingEvent.setDate(eventDto.getDate());
        existingEvent.setLocation(eventDto.getLocation());

        Event updatedEvent = eventRepository.save(existingEvent);
        return convertToDto(updatedEvent);
    }

    @Override
    public void deleteEvent(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new RuntimeException("Event not found with id: " + id);
        }
        eventRepository.deleteById(id);
    }

    @Override
    public List<EventResponseDto> findAllEvents() {
        return eventRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private EventResponseDto convertToDto(Event event) {
        EventResponseDto dto = new EventResponseDto();
        dto.setId(event.getId());
        dto.setName(event.getName());
        dto.setDate(event.getDate());
        dto.setLocation(event.getLocation());
        return dto;
    }
}