package student.pg;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Application implements Comparable, Serializable {
    private String name;
    private int applicationSize;
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
                ", level=" + getApplicationSize() +
                ", disk=" + getDisk().getName() +
                '}';
    }

}
