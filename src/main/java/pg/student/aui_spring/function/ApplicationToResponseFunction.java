package pg.student.aui_spring.function;

import org.springframework.stereotype.Component;
import pg.student.aui_spring.dto.GetApplicationResponse;
import pg.student.aui_spring.entity.Application;

import java.util.function.Function;

@Component
public class ApplicationToResponseFunction implements Function<Application, GetApplicationResponse> {
    @Override
    public GetApplicationResponse apply(Application application) {
        return GetApplicationResponse.builder()
                .uuid(application.getUuid())
                .name(application.getName())
                .size(application.getApplicationSize())
                .disk(GetApplicationResponse.Disk.builder()
                        .id(application.getDisk().getUuid())
                        .name(application.getDisk().getName())
                        .build())
                .build();
    }
}
