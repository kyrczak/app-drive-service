package pg.student.aui_spring.function;

import org.springframework.stereotype.Component;
import pg.student.aui_spring.dto.PutApplicationRequest;
import pg.student.aui_spring.entity.Application;
import pg.student.aui_spring.entity.Disk;

import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class RequestToApplicationFunction implements BiFunction<UUID, PutApplicationRequest, Application> {
    @Override
    public Application apply(UUID uuid, PutApplicationRequest request) {
        return Application.builder()
                .uuid(uuid)
                .name(request.getName())
                .applicationSize(request.getSize())
                .disk(Disk.builder()
                        .uuid(request.getDisk())
                        .build())
                .build();
    }
}
