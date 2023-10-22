package pg.student.aui_spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "applications")
public class Application implements Comparable, Serializable {
    @Id
    private UUID uuid;
    @Column
    private String name;
    @Column(name = "application_size")
    private int applicationSize;
    @ManyToOne
    @JoinColumn(name = "disk")
    private Disk disk;

    @Override
    public int compareTo(Object o) {
        Application c = (Application) o;
        return this.getApplicationSize() - c.getApplicationSize();
    }

    @Override
    public String toString() {
        return "Application{" +
                "name='" + getName() + '\'' +
                ", applicationSize=" + getApplicationSize() +
                ", disk=" + getDisk().getName() +
                '}';
    }

}
