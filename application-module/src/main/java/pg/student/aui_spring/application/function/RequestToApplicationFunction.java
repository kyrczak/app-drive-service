package pg.student.aui_spring.application.function;

import org.springframework.stereotype.Component;
import pg.student.aui_spring.application.dto.PutApplicationRequest;
import pg.student.aui_spring.application.entity.Application;

import java.util.UUID;
import java.util.function.BiFunction;

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
