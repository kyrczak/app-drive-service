package student.pg;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@Setter
@EqualsAndHashCode(exclude = "applicationList")
@AllArgsConstructor
public class FloppyDisk implements Comparable, Serializable {
    private String name;
    private int diskSize;
    private List<Application> applicationList;

    @Override
    public String toString() {
        return "FloppyDisk{" +
                "name='" + name + '\'' +
                ", baseArmor=" + diskSize +
                ", applicationList=" + applicationList +
                '}';
    }
    @Override
    public int compareTo(Object o) {
        FloppyDisk p = (FloppyDisk) o;
        return this.getDiskSize() - p.getDiskSize();
    }

    public void addCharacter(Application application) {
        this.getApplicationList().add(application);
    }
}
