package pg.student.aui_spring.application.function;

import org.springframework.stereotype.Component;
import pg.student.aui_spring.application.dto.GetApplicationsResponse;
import pg.student.aui_spring.application.entity.Application;

import java.util.List;
import java.util.function.Function;

@Component
public class ApplicationsToResponseFunction implements Function<List<Application>, GetApplicationsResponse> {
    @Override
    public GetApplicationsResponse apply(List<Application> applications) {
        return GetApplicationsResponse.builder()
                .applications(applications.stream()
                        .map(application -> GetApplicationsResponse.Application.builder()
                                .uuid(application.getUuid())
                                .name(application.getName())
                                .build())
                        .toList())
                .build();
    }
}
