package student.pg;

import java.util.List;
import java.util.Objects;

public class Profession {
    private String name;
    private int baseArmor;
    private List<Characters> charactersList;

    public Profession() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseArmor() {
        return baseArmor;
    }

    public void setBaseArmor(int baseArmor) {
        this.baseArmor = baseArmor;
    }

    public List<Characters> getCharactersList() {
        return charactersList;
    }

    public void setCharactersList(List<Characters> charactersList) {
        this.charactersList = charactersList;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "name='" + name + '\'' +
                ", baseArmor=" + baseArmor +
                ", charactersList=" + charactersList +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profession that = (Profession) o;
        return baseArmor == that.baseArmor && Objects.equals(name, that.name) && Objects.equals(charactersList, that.charactersList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, baseArmor, charactersList);
    }

    //Implement the Comparable interface with natural ordering based on the baseArmor field.
    public int compareTo(Object o) {
        Profession p = (Profession) o;
        return this.getBaseArmor() - p.getBaseArmor();
    }
}
