package pg.student.application_module.disk.function;

import org.springframework.stereotype.Component;
import pg.student.application_module.disk.dto.PutDiskRequest;
import pg.student.application_module.disk.entity.Disk;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToDiskFunction implements BiFunction<UUID, PutDiskRequest, Disk> {
    @Override
    public Disk apply(UUID uuid, PutDiskRequest putDiskRequest) {
        return Disk.builder()
                .uuid(uuid)
                .name(putDiskRequest.getName())
                .diskSize(putDiskRequest.getSize())
                .build();
    }
}
