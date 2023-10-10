package student.pg;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class ApplicationDto implements Comparable {
    String name;
    int level;
    String profession;

    @Override
    public int compareTo(Object o) {
        ApplicationDto c = (ApplicationDto) o;
        return this.getLevel() - c.getLevel();
    }

    @Override
    public String toString() {
        return "ApplicationDto{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", floppyDisk='" + profession + '\'' +
                '}';
    }
}
