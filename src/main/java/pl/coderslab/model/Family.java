package pl.coderslab.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "families")
public class Family {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100)
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "family")
    private List<FamilyMember> member = new ArrayList<>();

    @OneToMany(mappedBy = "family", cascade = CascadeType.MERGE)
    private List<Event> events = new ArrayList<>();

    @OneToOne(mappedBy = "family")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FamilyMember> getMember() {
        return member;
    }

    public void setMember(List<FamilyMember> member) {
        this.member = member;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
