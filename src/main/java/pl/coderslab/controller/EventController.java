package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Event;
import pl.coderslab.model.Family;
import pl.coderslab.model.FamilyMember;
import pl.coderslab.model.User;
import pl.coderslab.service.EventService;
import pl.coderslab.service.MemberService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;
import java.util.*;

@Controller
@RequestMapping("/app/events")
public class EventController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private EventService eventService;

    @ModelAttribute("members")
    public List<FamilyMember> members(HttpSession session) {
        User user = (User) session.getAttribute("logged");
        Family family = user.getFamily();
        List<FamilyMember> members = memberService.findAllFamilyMembers(family);
        return members;
    }

    @Autowired
    private JavaMailSender mailSender;

    @ModelAttribute("categories")
    public List<String> categories() {
        return Arrays.asList(new String[]{"leisures", "duties"});
    }


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("event", new Event());
        return "events/add";
    }

    @PostMapping("/add")
    public String addEvent(@Valid Event event, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "events/add";
        } else {
            User user = (User) session.getAttribute("logged");
            Family family = user.getFamily();
            event.setFamily(family);
            eventService.saveEvent(event);

        }
        return "users/main";
    }

    @GetMapping("/remove/{id}")
    public String removeMember(@PathVariable Long id) {
        eventService.removeEvent(id);
        return "redirect:/app/members/all";

    }

    @GetMapping("/edit/{id}")
    public String editMember(@PathVariable Long id, Model model) {
        Event event = eventService.findById(id);
        model.addAttribute("event", event);
        return "events/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid Event event, BindingResult result) {
        if (result.hasErrors()) {
            return "events/edit";
        }
        eventService.saveEvent(event);
        return "redirect:/app/events/week";
    }


    @RequestMapping("/week")
    public String showWeekPlan(Model model, HttpSession session) {
        LocalDate today = LocalDate.now();
        if (today.getDayOfWeek() != DayOfWeek.MONDAY) {
            switch (today.getDayOfWeek()) {
                case TUESDAY:
                    today = today.minusDays(1);
                    break;
                case WEDNESDAY:
                    today = today.minusDays(2);
                    break;
                case THURSDAY:
                    today = today.minusDays(3);
                    break;
                case FRIDAY:
                    today = today.minusDays(4);
                    break;
                case SATURDAY:
                    today = today.minusDays(5);
                    break;
                case SUNDAY:
                    today = today.minusDays(6);
                    break;
            }

        }
        LocalDate weekEnd = today.plusDays(6);
        model.addAttribute("today", today);
        User user = (User) session.getAttribute("logged");
        Family family = user.getFamily();

        List<Event> todayEvents = eventService.showWeekEvents(today, weekEnd, family);

        Map<LocalDate, Map<LocalTime, Event>> eventsMap = new LinkedHashMap<>();
//        Map <String, Event> map = new LinkedHashMap<>();
        for (Event event : todayEvents) {
            Map<LocalTime, Event> map;
            if (eventsMap.get(event.getDate()) == null) {
                map = new HashMap<>();
            } else {
                map = eventsMap.get(event.getDate());
            }
            map.put(event.getTimeFrom(), event);
            eventsMap.put(event.getDate(), map);

        }

        //LocalTime.of(5, 7);

        model.addAttribute("eventsMap", eventsMap);
        return "events/week";


    }

    @RequestMapping("/prevweek")
    public String showPrevWeekPlan(Model model, HttpSession session) {
        LocalDate today = LocalDate.now().minusDays(7);
        if (today.getDayOfWeek() != DayOfWeek.MONDAY) {
            switch (today.getDayOfWeek()) {
                case TUESDAY:
                    today = today.minusDays(1);
                    break;
                case WEDNESDAY:
                    today = today.minusDays(2);
                    break;
                case THURSDAY:
                    today = today.minusDays(3);
                    break;
                case FRIDAY:
                    today = today.minusDays(4);
                    break;
                case SATURDAY:
                    today = today.minusDays(5);
                    break;
                case SUNDAY:
                    today = today.minusDays(6);
                    break;
            }
        }
        LocalDate weekEnd = today.plusDays(6);
        model.addAttribute("today", today);
        User user = (User) session.getAttribute("logged");
        Family family = user.getFamily();

        List<Event> todayEvents = eventService.showWeekEvents(today, weekEnd, family);

        Map<LocalDate, Map<LocalTime, Event>> eventsMap = new LinkedHashMap<>();
//        Map <String, Event> map = new LinkedHashMap<>();
        for (Event event : todayEvents) {
            Map<LocalTime, Event> map;
            if (eventsMap.get(event.getDate()) == null) {
                map = new HashMap<>();
            } else {
                map = eventsMap.get(event.getDate());
            }
            map.put(event.getTimeFrom(), event);
            eventsMap.put(event.getDate(), map);

        }

        //LocalTime.of(5, 7);

        model.addAttribute("eventsMap", eventsMap);
        return "events/prevweek";


    }

    @RequestMapping("/nextweek")
    public String showNextWeekPlan(Model model, HttpSession session) {
        LocalDate today = LocalDate.now().plusDays(7);
        if (today.getDayOfWeek() != DayOfWeek.MONDAY) {
            switch (today.getDayOfWeek()) {
                case TUESDAY:
                    today = today.minusDays(1);
                    break;
                case WEDNESDAY:
                    today = today.minusDays(2);
                    break;
                case THURSDAY:
                    today = today.minusDays(3);
                    break;
                case FRIDAY:
                    today = today.minusDays(4);
                    break;
                case SATURDAY:
                    today = today.minusDays(5);
                    break;
                case SUNDAY:
                    today = today.minusDays(6);
                    break;
            }
        }
        LocalDate weekEnd = today.plusDays(6);
        model.addAttribute("today", today);
        User user = (User) session.getAttribute("logged");
        Family family = user.getFamily();

        List<Event> todayEvents = eventService.showWeekEvents(today, weekEnd, family);

        Map<LocalDate, Map<LocalTime, Event>> eventsMap = new LinkedHashMap<>();
//        Map <String, Event> map = new LinkedHashMap<>();
        for (Event event : todayEvents) {
            Map<LocalTime, Event> map;
            if (eventsMap.get(event.getDate()) == null) {
                map = new HashMap<>();
            } else {
                map = eventsMap.get(event.getDate());
            }
            map.put(event.getTimeFrom(), event);
            eventsMap.put(event.getDate(), map);

        }

        //LocalTime.of(5, 7);

        model.addAttribute("eventsMap", eventsMap);
        return "events/nextweek";


    }

    @GetMapping("/notify/{id}")
    public String sendMessage(@PathVariable long id) {

        Event event = eventService.findById(id);
        String subject = "new event in your Family Manager!";
        List<FamilyMember> members = event.getMembers();
        List<String> emails = new ArrayList<>();
        for (FamilyMember member : members) {
            emails.add(member.getEmail());

        }
        for (String email : emails) {
            String text = "event: " + event.getName() + " participants: " + event.getMembers().toString() + " date: " + event.getDate() + " time: " + event.getTimeFrom() + "-" + event.getTimeTo();
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject(subject);
            message.setText(text);
            mailSender.send(message);
        }

        return "redirect:/app/events/week";

    }

}
