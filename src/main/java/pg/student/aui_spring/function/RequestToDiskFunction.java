package pg.student.aui_spring.function;

import org.springframework.stereotype.Component;
import pg.student.aui_spring.dto.PutDiskRequest;
import pg.student.aui_spring.entity.Disk;

import java.util.UUID;
import java.util.function.BiFunction;
@Component
public class RequestToDiskFunction implements BiFunction<UUID, PutDiskRequest, Disk> {
    @Override
    public Disk apply(UUID uuid, PutDiskRequest putDiskRequest) {
        return null;
    }
}
