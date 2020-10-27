package icu.random.entity;

import icu.random.util.event.EventType;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.Data;

@Entity(name = "Event")
@Data
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_generator")
  @SequenceGenerator(name = "event_generator", sequenceName = "event_event_id_seq", allocationSize = 1)
  @Column(name = "event_id")
  private Integer id;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "language")
  private String language;

  @Enumerated(EnumType.STRING)
  @Column(name = "event_type")
  private EventType eventType;

  public Event(LocalDateTime createdAt, String language, EventType eventType) {
    this.createdAt = createdAt;
    this.language = language;
    this.eventType = eventType;
  }

  public Event() {
  }
}
