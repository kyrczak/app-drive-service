package pg.student.disk.function;

import org.springframework.stereotype.Component;
import pg.student.aui_spring.application.dto.GetDiskResponse;

import java.util.function.Function;
@Component
public class DiskToResponseFunction implements Function<Disk, GetDiskResponse> {
    @Override
    public GetDiskResponse apply(Disk disk) {
        return GetDiskResponse.builder()
                .uuid(disk.getUuid())
                .name(disk.getName())
                .size(disk.getDiskSize())
                .build();
    }
}
