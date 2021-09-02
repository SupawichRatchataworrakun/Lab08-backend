package se331.lab.rest.dao;

import org.aspectj.weaver.ast.Or;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class OrganizerDaolmpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(123L)
                .name("Meow Town")
                .address("Kat Laydee")
                .build());
        organizerList.add(Organizer.builder()
                .id(456L)
                .name("Flora City")
                .address("Fern Pollin")
                .build());
        organizerList.add(Organizer.builder()
                .id(789L)
                .name("Playa Del Carmen")
                .address("Carey Wales")
                .build());
        organizerList.add(Organizer.builder()
                .id(1001L)
                .name("Woof Town")
                .address("Dawg Dahd")
                .build());
        organizerList.add(Organizer.builder()
                .id(1002L)
                .name("Tin City")
                .address("Kahn Opiner")
                .build());
        organizerList.add(Organizer.builder()
                .id(1003L)
                .name("Highway 50")
                .address("Brody Kill")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return new PageImpl<Organizer>(organizerList.subList(firstIndex, firstIndex+pageSize), PageRequest.of(page,pageSize),organizerList.size());
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(organizer -> organizer.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Organizer save(Organizer organizer) {
        organizer.setId(organizerList.get(organizerList.size()-1).getId()+1);
        organizerList.add(organizer);
        return organizer;
    }
}
