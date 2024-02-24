package pg.student.application_module.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pg.student.application_module.application.entity.Application;
import pg.student.application_module.disk.entity.Disk;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, UUID> {
    Optional<Application> findApplicationByName(String name);
    List<Application> findAllByDisk(Disk disk);
}
