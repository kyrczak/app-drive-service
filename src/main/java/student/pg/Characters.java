package student.pg;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Characters implements Comparable {
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
