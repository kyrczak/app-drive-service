package pg.student.aui_spring.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@EqualsAndHashCode(exclude = "applicationList")
@AllArgsConstructor
@Entity
@Table(name = "disks")
public class Disk implements Comparable, Serializable {
    @Id
    private UUID uuid;

    @Column
    private String name;
    @Column(name = "disk_size")
    private int diskSize;
    @OneToMany(mappedBy = "disk")
    private List<Application> applicationList;

    public Disk() {

    }

    @Override
    public String toString() {
        return "Disk{" +
                "name='" + name + '\'' +
                ", diskSize=" + diskSize +
                ", applicationList=" + applicationList +
                '}';
    }
    @Override
    public int compareTo(Object o) {
        Disk p = (Disk) o;
        return this.getDiskSize() - p.getDiskSize();
    }

    public void addCharacter(Application application) {
        this.getApplicationList().add(application);
    }
}