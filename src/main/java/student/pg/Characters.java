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
public class Characters implements Comparable, Serializable {
    private String name;
    private int level;
    private Profession profession;

    @Override
    public int compareTo(Object o) {
        Characters c = (Characters) o;
        return this.getLevel() - c.getLevel();
    }

    @Override
    public String toString() {
        return "Characters{" +
                "name='" + getName() + '\'' +
                ", level=" + getLevel() +
                ", profession=" + getProfession().getName() +
                '}';
    }

}
