package pg.student.disk.event.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

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
}
