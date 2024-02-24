package pg.student.aui_spring.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

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
    @ToString.Exclude
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