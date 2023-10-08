package student.pg;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class CharacterDto implements Comparable {
    String name;
    int level;
    String profession;

    @Override
    public int compareTo(Object o) {
        CharacterDto c = (CharacterDto) o;
        return this.getLevel() - c.getLevel();
    }

    @Override
    public String toString() {
        return "CharacterDto{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", profession='" + profession + '\'' +
                '}';
    }
}
