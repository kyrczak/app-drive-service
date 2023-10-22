package pg.student.aui_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pg.student.aui_spring.repository.DiskRepository;
@Service
public class DiskService {
    private DiskRepository repository;
    @Autowired
    public DiskService(DiskRepository repository) {
        this.repository = repository;
    }
}
