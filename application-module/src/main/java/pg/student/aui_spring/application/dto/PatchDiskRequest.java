package pg.student.aui_spring.application.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PatchDiskRequest {
    private String name;
    private int size;
}
