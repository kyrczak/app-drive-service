package student.pg;

import java.util.List;

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
}
