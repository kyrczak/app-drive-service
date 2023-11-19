package pg.student.aui_spring.application.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PutApplicationRequest {
    private String name;
    private int size;
    private UUID disk;
}
