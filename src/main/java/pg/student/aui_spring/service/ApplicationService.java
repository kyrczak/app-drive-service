package pg.student.aui_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pg.student.aui_spring.entity.Application;
import pg.student.aui_spring.repository.ApplicationRepository;
import pg.student.aui_spring.repository.DiskRepository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;

@Service
public class ApplicationService {
    private ApplicationRepository repository;
    private DiskRepository diskRepository;
    @Autowired
    public ApplicationService(ApplicationRepository repository, DiskRepository diskRepository) {
        this.repository = repository;
        this.diskRepository = diskRepository;
    }
    public void create(Application application) {
        repository.save(application);
    }
    public Optional<Application> findByName(String name) {
        return repository.findApplicationByName(name);
    }
    public Optional<Application> findByDiskAndId(UUID diskId, UUID id) {
        return diskRepository.findById(diskId)
                .flatMap(disk -> disk.getApplications()
                        .stream()
                        .filter(application -> application.getUuid().equals(id))
                        .findFirst());
    }
    public Optional<Application> find(UUID id) {
        return repository.findById(id);
    }
    public List<Application> findAll() {
        return repository.findAll();
    }
    public Optional<List<Application>> findAllByDisk(UUID diskId) {
        return diskRepository.findById(diskId)
                .map(repository::findAllByDisk);
    }
    public void delete(String name) {
        repository.findApplicationByName(name).ifPresent(repository::delete);
    }
}
