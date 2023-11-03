package pg.student.aui_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pg.student.aui_spring.entity.Application;
import pg.student.aui_spring.entity.Disk;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, UUID> {
    Optional<Application> findApplicationByName(String name);
    List<Application> findAllByDisk(Disk disk);
}
