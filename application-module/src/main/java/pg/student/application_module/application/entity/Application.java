package pg.student.application_module.application.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.UUID;
import pg.student.application_module.disk.entity.Disk;

@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "applications")
public class Application implements Serializable {
    @Id
    @ToString.Exclude
    private UUID uuid;
    @Column
    private String name;
    @Column(name = "application_size")
    private int applicationSize;
    @ManyToOne
    @JoinColumn(name = "disk")
    private Disk disk;
}
