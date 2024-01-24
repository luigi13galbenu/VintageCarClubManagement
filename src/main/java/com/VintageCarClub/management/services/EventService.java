package com.VintageCarClub.management.services;

import com.VintageCarClub.management.models.dtos.EventRequestDto;
import com.VintageCarClub.management.models.dtos.EventResponseDto;

import java.util.List;

public interface EventService {
    EventResponseDto saveEvent(EventRequestDto eventDto);

    EventResponseDto findEventById(Long id);

    EventResponseDto updateEvent(Long id, EventRequestDto eventDto);

    void deleteEvent(Long id);

    List<EventResponseDto> findAllEvents();
}
