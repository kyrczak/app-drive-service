package student.pg;

import java.util.Comparator;
import java.util.Objects;

public class CharactersComparator implements Comparator<Characters> {
    @Override
    public int compare(Characters o1, Characters o2) {
        if(o1.getName().compareTo(o2.getName())!=0) {
            return o1.getName().compareTo(o2.getName());
        }
        else if(o1.getLevel() != o2.getLevel()) {
            return Integer.compare(o1.getLevel(), o2.getLevel());
        }
        else {
            return Objects.compare(o1.getProfession(),o2.getProfession(),new ProfessionComparator());
        }
    }
}
