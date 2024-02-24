package pg.student.disk.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GetDiskResponse {
    private UUID uuid;
    private String name;
    private int size;
}
