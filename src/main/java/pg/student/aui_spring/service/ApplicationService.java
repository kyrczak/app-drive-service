package pg.student.aui_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pg.student.aui_spring.repository.ApplicationRepository;
@Service
public class ApplicationService {
    private ApplicationRepository repository;
    @Autowired
    public ApplicationService(ApplicationRepository repository) {
        this.repository = repository;
    }
}
