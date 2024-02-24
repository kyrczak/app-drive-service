package pg.student.disk.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PutDiskRequest {
    private String name;
    private int size;
}
