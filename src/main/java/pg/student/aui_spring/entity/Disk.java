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
public class Disk implements Comparable, Serializable {
    @Id
    @ToString.Exclude
    private UUID uuid;

    @Column
    private String name;

    @Column(name = "disk_size")
    private int diskSize;

    @OneToMany(mappedBy = "disk")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Application> applications;

    @Override
    public int compareTo(Object o) {
        Disk p = (Disk) o;
        return this.getDiskSize() - p.getDiskSize();
    }
}