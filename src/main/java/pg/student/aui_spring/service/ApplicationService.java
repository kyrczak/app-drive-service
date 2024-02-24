package pg.student.aui_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pg.student.aui_spring.entity.Application;
import pg.student.aui_spring.repository.ApplicationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    private ApplicationRepository repository;
    @Autowired
    public ApplicationService(ApplicationRepository repository) {
        this.repository = repository;
    }
    public void create(Application application) {
        repository.save(application);
    }
    public List<Application> findAll() {
        return repository.findAll();
    }
    public void delete(String name) {
        repository.findApplicationByName(name).ifPresent(repository::delete);
    }
}
