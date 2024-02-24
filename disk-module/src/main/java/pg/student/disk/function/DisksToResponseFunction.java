package pg.student.disk.function;

import org.springframework.stereotype.Component;
import pg.student.disk.dto.GetDisksResponse;
import pg.student.disk.entity.Disk;
import java.util.List;
import java.util.function.Function;

@Component
public class DisksToResponseFunction implements Function<List<Disk>, GetDisksResponse> {
    @Override
    public GetDisksResponse apply(List<Disk> disks) {
        return GetDisksResponse.builder()
                .disks(disks.stream()
                        .map(disk -> GetDisksResponse.Disk.builder()
                                .uuid(disk.getUuid())
                                .name(disk.getName())
                                .build())
                        .toList())
                .build();
    }
}
