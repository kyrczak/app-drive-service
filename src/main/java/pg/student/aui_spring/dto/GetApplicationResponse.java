package pg.student.aui_spring.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GetApplicationResponse {
    private UUID uuid;
    private String name;
    private int size;
}
