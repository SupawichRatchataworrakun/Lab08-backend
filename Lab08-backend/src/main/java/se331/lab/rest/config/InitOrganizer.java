package se331.lab.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;

@Component
public class InitOrganizer implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    OrganizerRepository organizerRepository;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        organizerRepository.save(Organizer.builder()
                .id(123L)
                .name("Meow Town")
                .address("Kat Laydee")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(456L)
                .name("Flora City")
                .address("Fern Pollin")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(789L)
                .name("Playa Del Carmen")
                .address("Carey Wales")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(1001L)
                .name("Woof Town")
                .address("Dawg Dahd")
                .build());
    }
}
