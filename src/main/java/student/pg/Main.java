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
        System.out.println("Task 2");

        Disk software = Disk.builder()
                .name("Software")
                .diskSize(20)
                .applicationList(new LinkedList<>())
                .build();
        Disk firmware = Disk.builder()
                .name("Firmware")
                .diskSize(10)
                .applicationList(new LinkedList<>())
                .build();

        Application application1 = Application.builder()
                .name("Painting app")
                .applicationSize(18)
                .disk(software)
                .build();
        Application application2 = Application.builder()
                .name("Writing app")
                .applicationSize(20)
                .disk(software)
                .build();
        Application application3 = Application.builder()
                .name("Printer firmware")
                .applicationSize(21)
                .disk(firmware)
                .build();
        Application application4 = Application.builder()
                .name("Microphone firmware")
                .applicationSize(28)
                .disk(firmware)
                .build();
        Application application5 = Application.builder()
                .name("Keyboard firmware")
                .applicationSize(22)
                .disk(firmware)
                .build();

        software.addCharacter(application1);
        software.addCharacter(application2);
        firmware.addCharacter(application3);
        firmware.addCharacter(application4);
        firmware.addCharacter(application5);

        Collection<Disk> diskCollection = new LinkedList<>();
        diskCollection.add(software);
        diskCollection.add(firmware);

        diskCollection.forEach(disk -> {
            System.out.println(disk);
        });

        // Task 3
        System.out.println("Task 3");
        Set<Application> applicationSet = List.of(software, firmware).stream()
                .flatMap(disk -> disk.getApplicationList().stream())
                .collect(Collectors.toSet());
        System.out.println(applicationSet);

        // Task 4
        System.out.println("Task 4");
        List<Application> filteredCharacters = applicationSet.stream()
                .filter(application -> application.getApplicationSize() > 20)
                .sorted()
                .toList();
        System.out.println(filteredCharacters);
        System.out.println();

        // Task 5
        System.out.println("Task 5");
        List<ApplicationDto> applicationDtoList = applicationSet.stream()
                .map(application -> ApplicationDto.builder()
                        .name(application.getName())
                        .level(application.getApplicationSize())
                        .disk(application.getDisk().getName())
                        .build())
                .sorted()
                .toList();
        System.out.println(applicationDtoList);

        // Task 6
        System.out.println("Task 6");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("disks.bin"))) {
            oos.writeObject(List.of(software, firmware));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("disks.bin"))) {
            List<Disk> disks = (List<Disk>) ois.readObject();
            disks.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Task 7
        System.out.println("Task 7");
        ForkJoinPool pool = new ForkJoinPool(3);
        Collection<Disk> disks = List.of(software, firmware);
        try {
            pool.submit(() -> {
                disks.stream()
                        .parallel()
                        .forEach(disk -> {
                            disk.getApplicationList().forEach(
                                    application -> {
                                        try {
                                            Thread.sleep(1500);
                                            System.out.println(disk);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                    }
                            );

                        });
            }).get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        pool.shutdown();
    }
}