package pg.student.disk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pg.student.disk.entity.Disk;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface DiskRepository extends JpaRepository<Disk, UUID> {
    Optional<Disk> findDiskByDiskSize(int diskSize);
    Optional<Disk> findDiskByName(String diskName);
}
