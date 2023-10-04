package student.pg;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Characters implements Comparable {
    @Id
    private String name;
    private int level;
    @ManyToOne
    private Profession profession;

    public Characters(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    @Override
    public int compareTo(Object o) {
        Characters c = (Characters) o;
        return this.getLevel() - c.getLevel();
    }

    // Override the equals method based on the name and level fields.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Characters)) return false;
        Characters that = (Characters) o;
        return getLevel() == that.getLevel() && Objects.equals(getName(), that.getName());
    }

    // Override the hashCode method based on the name and level fields.
    @Override
    public int hashCode() {
        return Objects.hash(name, level);
    }

    @Override
    public String toString() {
        return "Characters{" +
                "name='" + getName() + '\'' +
                ", level=" + getLevel() +
                ", profession=" + getProfession() +
                '}';
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }
}
