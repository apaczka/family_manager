package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Event;
import pl.coderslab.service.EventService;

public class EventConverter implements Converter<String, Event> {

    @Autowired
   private EventService eventService;

    @Override
    public Event convert(String s) {
       return eventService.findById(Long.parseLong(s));

    }
}
