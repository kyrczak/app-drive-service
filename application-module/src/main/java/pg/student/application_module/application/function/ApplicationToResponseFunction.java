package pg.student.application_module.application.function;

import org.springframework.stereotype.Component;
import pg.student.application_module.application.dto.GetApplicationResponse;
import pg.student.application_module.application.entity.Application;

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
                        .build())
                .build();
    }
}
