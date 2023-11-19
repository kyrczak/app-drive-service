package pg.student.aui_spring.disk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import pg.student.aui_spring.application.entity.Application;

@Builder
@Getter
@Setter
@EqualsAndHashCode()
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "disks")
public class Disk implements Serializable {
    @Id
    private UUID uuid;

    @Column
    private String name;

    @Column(name = "disk_size")
    private int diskSize;

    @OneToMany(mappedBy = "disk", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Application> applications;
}