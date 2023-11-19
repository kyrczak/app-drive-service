package pg.student.disk.function;

import org.springframework.stereotype.Component;
import pg.student.disk.dto.PutDiskRequest;
import pg.student.disk.entity.Disk;
import java.util.UUID;
import java.util.function.BiFunction;
@Component
public class RequestToDiskFunction implements BiFunction<UUID, PutDiskRequest, Disk> {
    @Override
    public Disk apply(UUID uuid, PutDiskRequest putDiskRequest) {
        return null;
    }
}
