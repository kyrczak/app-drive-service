package pg.student.disk.event.repository;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pg.student.disk.entity.Disk;

import java.util.UUID;

@Repository
public class DiskEventRestRepository implements DiskEventRepository{
    private final RestTemplate restTemplate;

    @Autowired
    public DiskEventRestRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/disks/{id}", id);
    }

    @Override
    public void create(Disk disk, UUID id) {
        String url = "/api/disks/" + id.toString();
        restTemplate.exchange(
                url,
                HttpMethod.PUT,
                new HttpEntity<>(disk),
                Void.class
        );
    }
}
