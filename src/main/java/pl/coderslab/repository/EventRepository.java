package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Event;
import pl.coderslab.model.Family;
import pl.coderslab.model.FamilyMember;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findEventByDateBetweenAndAndFamily(LocalDate start, LocalDate end, Family family);

    List<Event> findEventByFamily(Family family);

    List<Event> findEventByDateBetweenAndMembers(LocalDate start, LocalDate end, FamilyMember member);

}