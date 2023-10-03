package student.pg;

import java.util.Comparator;

public class ProfessionComparator implements Comparator<Profession> {
    @Override
    public int compare(Profession o1, Profession o2) {
        if(o1.getName().compareTo(o2.getName())!=0) {
            return o1.getName().compareTo(o2.getName());
        }
        else {
            return Integer.compare(o1.getBaseArmor(), o2.getBaseArmor());
        }
    }
}
