package pg.student.application_module.application.dto;

import lombok.*;

import java.util.UUID;

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
    private UUID diskUUID;
}
