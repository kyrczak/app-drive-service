package student.pg;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@Setter
@EqualsAndHashCode(exclude = "charactersList")
@AllArgsConstructor
public class Profession implements Comparable, Serializable {
    private String name;
    private int baseArmor;
    private List<Characters> charactersList;

    @Override
    public String toString() {
        return "Profession{" +
                "name='" + name + '\'' +
                ", baseArmor=" + baseArmor +
                ", charactersList=" + charactersList +
                '}';
    }
    @Override
    public int compareTo(Object o) {
        Profession p = (Profession) o;
        return this.getBaseArmor() - p.getBaseArmor();
    }

    public void addCharacter(Characters characters) {
        this.getCharactersList().add(characters);
    }
}