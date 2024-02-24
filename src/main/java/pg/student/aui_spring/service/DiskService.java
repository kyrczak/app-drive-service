package pg.student.aui_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pg.student.aui_spring.entity.Application;
import pg.student.aui_spring.entity.Disk;
import pg.student.aui_spring.repository.DiskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DiskService {
    private DiskRepository repository;
    @Autowired
    public DiskService(DiskRepository repository) {
        this.repository = repository;
    }
    public Optional<Disk> find(String diskName) {
        return repository.findDiskByName(diskName);
    }

    public List<Disk> findAll() {
        return repository.findAll();
    }
    public void create(Disk disk) {
        repository.save(disk);
    }
}
