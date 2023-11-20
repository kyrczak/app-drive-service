package pg.student.disk.event.repository;

import pg.student.disk.entity.Disk;

import java.util.UUID;

public interface DiskEventRepository {
    void delete(UUID id);

    void create(UUID id);
}
