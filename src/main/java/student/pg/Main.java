package student.pg;

import java.io.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Task 2
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

        // Task 3
        System.out.println("Task 3");
        Set<Characters> charactersSet = List.of(lumberjack, fisherman).stream()
                .flatMap(profession -> profession.getCharactersList().stream())
                .collect(Collectors.toSet());
        System.out.println(charactersSet);

        // Task 4
        System.out.println("Task 4");
        List<Characters> filteredCharacters = charactersSet.stream()
                .filter(characters -> characters.getLevel() > 20)
                .sorted()
                .toList();
        System.out.println(filteredCharacters);
        System.out.println();

        // Task 5
        System.out.println("Task 5");
        List<CharacterDto> characterDtoList = charactersSet.stream()
                .map(characters -> CharacterDto.builder()
                        .name(characters.getName())
                        .level(characters.getLevel())
                        .profession(characters.getProfession().getName())
                        .build())
                .sorted()
                .toList();
        System.out.println(characterDtoList);

        // Task 6
        System.out.println("Task 6");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("professions.bin"))) {
            oos.writeObject(List.of(lumberjack, fisherman));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("professions.bin"))) {
            List<Profession> professions = (List<Profession>) ois.readObject();
            professions.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Task 7
        System.out.println("Task 7");
        ForkJoinPool pool = new ForkJoinPool(1);
        Collection<Profession> professions = List.of(lumberjack, fisherman);
        try {
            pool.submit(() -> {
                professions.stream()
                        .parallel()
                        .forEach(profession -> {
                            try {
                                Thread.sleep(1500);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println(profession);
                        });
            }).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}