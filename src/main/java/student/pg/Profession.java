package student.pg;

import lombok.*;

import java.util.List;
import java.util.Objects;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Profession implements Comparable {
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
        if(Objects.equals(characters.getProfession().toString(), this.name)) {
            this.charactersList.add(characters);
        }
        else {
            System.out.println("Incorrect character's profession");
        }
    }
}
