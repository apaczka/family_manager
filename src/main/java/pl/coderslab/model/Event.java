package pl.coderslab.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    @NotBlank
    private String name;

    @Column(name = "start_hours")
    @NotNull
    private LocalTime timeFrom;

    @Column(name = "finish_hours")
    @NotNull
    private LocalTime timeTo;

    @NotNull
    private LocalDate date;

    @Column(name="categories", length=100)
    @NotBlank
    private String category;

    private String notes;

    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private List<FamilyMember> members = new ArrayList<>();

    @ManyToOne
    private Family family;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(LocalTime timeFrom) {
        this.timeFrom = timeFrom;
    }

    public LocalTime getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(LocalTime timeTo) {
        this.timeTo = timeTo;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<FamilyMember> getMembers() {
        return members;
    }

    public void setMembers(List<FamilyMember> members) {
        this.members = members;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", timeFrom=" + timeFrom +
                ", timeTo=" + timeTo +
                ", category='" + category + '\'' +
                ", notes='" + notes + '\'' +
                ", members=" + members +
                '}';
    }
}
