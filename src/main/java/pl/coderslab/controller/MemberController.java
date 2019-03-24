package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.*;

@Controller
@RequestMapping("/app/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private EventService eventService;

    @ModelAttribute("roles")
    private List<String> roles(){

        return Arrays.asList(new String[]{"father", "mother", "son", "dougther", "grandfather", "grandmother", "uncle", "aunt"});
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("member", new FamilyMember());
        return "members/add";
    }

    @PostMapping("/add")
    public String addMember(@Valid FamilyMember member, BindingResult result, HttpSession session){
        if(result.hasErrors()){
            return "members/add";
        }else{
           User user = (User)session.getAttribute("logged");
           Family family = user.getFamily();
           member.setFamily(family);
           memberService.saveMember(member);

        }
    return "redirect:/app/members/all";
    }

@RequestMapping("/all")
    public String showAllMembers(Model model, HttpSession session){
    User user = (User)session.getAttribute("logged");
    Family family = user.getFamily();
    List<FamilyMember> members = memberService.findAllFamilyMembers(family);
    model.addAttribute("members", members);
    return "members/all";


}

@GetMapping("/remove/{id}")
    public String removeMember(@PathVariable Long id){
        memberService.removeMember(id);
        return "redirect:/app/members/all";

}

@GetMapping("/edit/{id}")
public String editMember(@PathVariable Long id, Model model){
        FamilyMember member = memberService.findbyId(id);
        model.addAttribute("member", member);
        return "members/edit";
}

    @PostMapping("/edit")
    public String update(@Valid FamilyMember member, BindingResult result){
        if(result.hasErrors()){
            return "members/edit";
        }
       memberService.saveMember(member);
        return "redirect:/app/members/all";
    }

    @RequestMapping("/plan/{id}")
    public String showWeekPlan(@PathVariable Long id, Model model){
        LocalDate today =LocalDate.now();
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
            }}
        LocalDate weekEnd = today.plusDays(6);
        model.addAttribute("today", today);
        FamilyMember member =memberService.findbyId(id);
        List<Event> todayEvents =eventService.showWeekEventByMember(today, weekEnd, member);

        Map<LocalDate, Map<LocalTime,Event>> eventsMap = new LinkedHashMap<>();
//        Map <String, Event> map = new LinkedHashMap<>();
        for(Event event : todayEvents){
            Map<LocalTime, Event> map;
            if (eventsMap.get(event.getDate()) == null) {
                map = new HashMap<>();
            } else {
                map = eventsMap.get(event.getDate());
            }
            map.put(event.getTimeFrom(),event);
            eventsMap.put(event.getDate(), map);

        }

        //LocalTime.of(5, 7);
        model.addAttribute("member", member);
        model.addAttribute("eventsMap",eventsMap);
        return "members/week";
    }

    @RequestMapping("/nextplan/{id}")
    public String showNextWeekPlan(@PathVariable Long id, Model model){
        LocalDate today =LocalDate.now().plusDays(7);
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
            }}
        LocalDate weekEnd = today.plusDays(6);
        model.addAttribute("today", today);
        FamilyMember member =memberService.findbyId(id);
        List<Event> todayEvents =eventService.showWeekEventByMember(today, weekEnd, member);

        Map<LocalDate, Map<LocalTime,Event>> eventsMap = new LinkedHashMap<>();
//        Map <String, Event> map = new LinkedHashMap<>();
        for(Event event : todayEvents){
            Map<LocalTime, Event> map;
            if (eventsMap.get(event.getDate()) == null) {
                map = new HashMap<>();
            } else {
                map = eventsMap.get(event.getDate());
            }
            map.put(event.getTimeFrom(),event);
            eventsMap.put(event.getDate(), map);

        }

        //LocalTime.of(5, 7);
//        model.addAttribute("member", member);
        model.addAttribute("member", member);
        model.addAttribute("eventsMap",eventsMap);
        return "members/nextplan";
    }
    @RequestMapping("/prevplan/{id}")
    public String showPrevWeekPlan(@PathVariable Long id, Model model){
        LocalDate today =LocalDate.now().minusDays(7);
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
            }}
        LocalDate weekEnd = today.plusDays(6);
        model.addAttribute("today", today);
        FamilyMember member =memberService.findbyId(id);
        List<Event> todayEvents =eventService.showWeekEventByMember(today, weekEnd, member);

        Map<LocalDate, Map<LocalTime,Event>> eventsMap = new LinkedHashMap<>();
//        Map <String, Event> map = new LinkedHashMap<>();
        for(Event event : todayEvents){
            Map<LocalTime, Event> map;
            if (eventsMap.get(event.getDate()) == null) {
                map = new HashMap<>();
            } else {
                map = eventsMap.get(event.getDate());
            }
            map.put(event.getTimeFrom(),event);
            eventsMap.put(event.getDate(), map);

        }

        //LocalTime.of(5, 7);
//        model.addAttribute("member", member);
        model.addAttribute("member", member);
        model.addAttribute("eventsMap",eventsMap);
        return "members/prevplan";
    }
}
