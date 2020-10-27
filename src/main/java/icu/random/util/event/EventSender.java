package icu.random.util.event;

import icu.random.entity.Event;
import icu.random.repository.EventRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventSender {

  private final EventRepository eventRepository;

  @Autowired
  public EventSender(EventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }

  public void send(EventType eventType) {
    this.send("en", eventType);
  }

  public void send(String language, EventType eventType) {
    eventRepository.save(new Event(LocalDateTime.now(), language, eventType));
  }
}
