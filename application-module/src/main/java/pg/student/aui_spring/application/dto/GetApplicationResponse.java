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
public class GetApplicationResponse {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    public static class Disk {
        private UUID id;
        private String name;
    }
    private UUID uuid;
    private String name;
    private int size;
    private Disk disk;
}
