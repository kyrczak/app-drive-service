package student.pg;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        Profession lumberjack = Profession.builder()
                .name("Lumberjack")
                .baseArmor(20)
                .charactersList(new LinkedList<>())
                .build();
        Profession fisherman = Profession.builder()
                .name("Fisherman")
                .baseArmor(10)
                .charactersList(new LinkedList<>())
                .build();

        Characters anna = Characters.builder()
                .name("Anna")
                .level(18)
                .profession(lumberjack)
                .build();
        Characters tom = Characters.builder()
                .name("Tom")
                .level(20)
                .profession(lumberjack)
                .build();
        Characters patrick = Characters.builder()
                .name("Patrick")
                .level(21)
                .profession(fisherman)
                .build();
        Characters kendrick = Characters.builder()
                .name("Kendrick")
                .level(28)
                .profession(fisherman)
                .build();
        Characters monica = Characters.builder()
                .name("Monica")
                .level(22)
                .profession(fisherman)
                .build();

        lumberjack.addCharacter(anna);
        lumberjack.addCharacter(tom);
        fisherman.addCharacter(patrick);
        fisherman.addCharacter(kendrick);
        fisherman.addCharacter(monica);

        //Using single StreamAPI pipeline create Set collections of all professions and all characters


    }
}