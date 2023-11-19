package pg.student.aui_spring.application.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PatchApplicationRequest {
    private String name;
    private int size;
}
