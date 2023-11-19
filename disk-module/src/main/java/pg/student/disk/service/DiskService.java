package pg.student.disk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pg.student.aui_spring.entity.Disk;
import pg.student.aui_spring.repository.DiskRepository;
import pg.student.disk.event.repository.DiskEventRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DiskService {
    private final DiskRepository repository;
    private final DiskEventRepository eventRepository;
    @Autowired
    public DiskService(DiskRepository repository, DiskEventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }
    public Optional<Disk> findByName(String diskName) {
        return repository.findDiskByName(diskName);
    }
    public Optional<Disk> find(UUID id) {return repository.findById(id);}
    public List<Disk> findAll() {
        return repository.findAll();
    }
    public void create(Disk disk) {
        repository.save(disk);
    }

    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);
    }
}
