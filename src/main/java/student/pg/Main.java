package student.pg;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

        // Task 2
        //Using single Stream API pipeline create a Set collection of all elements from all charactersList of all professions
        //and print it out.

        Set<Characters> charactersSet = List.of(lumberjack, fisherman).stream()
                .flatMap(profession -> profession.getCharactersList().stream())
                .collect(Collectors.toSet());
        System.out.println(charactersSet);

        // Task 3
        List<Characters> filteredCharacters = charactersSet.stream()
                .filter(characters -> characters.getLevel() > 20)
                .sorted()
                .toList();
        System.out.println(filteredCharacters);
        System.out.println();
        // Task 4
        List<CharacterDto> characterDtoList = charactersSet.stream()
                .map(characters -> CharacterDto.builder()
                        .name(characters.getName())
                        .level(characters.getLevel())
                        .profession(characters.getProfession().getName())
                        .build())
                .sorted()
                .toList();

    }
}