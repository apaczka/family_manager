package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Event;
import pl.coderslab.model.Family;
import pl.coderslab.model.FamilyMember;
import pl.coderslab.repository.EventRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Component
@Transactional
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public void saveEvent(Event event) {
        eventRepository.save(event);

    }

    public Event findById(Long id) {
        return eventRepository.findOne(id);
    }

    public void removeEvent(Long id) {
        eventRepository.delete(id);
    }

    public List<Event> showWeekEvents(LocalDate start, LocalDate end, Family family) {
        return eventRepository.findEventByDateBetweenAndAndFamily(start, end, family);
    }

    public List<Event> showWeekEventByFamily(Family family) {
        return eventRepository.findEventByFamily(family);
    }

    public List<Event> showWeekEventByMember(LocalDate start, LocalDate end, FamilyMember member) {
        return eventRepository.findEventByDateBetweenAndMembers(start, end, member);
    }
}
