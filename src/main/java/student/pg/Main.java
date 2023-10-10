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
        FloppyDisk software = FloppyDisk.builder()
                .name("Software")
                .diskSize(20)
                .applicationList(new LinkedList<>())
                .build();
        FloppyDisk firmware = FloppyDisk.builder()
                .name("Firmware")
                .diskSize(10)
                .applicationList(new LinkedList<>())
                .build();

        Application application1 = Application.builder()
                .name("Painting app")
                .applicationSize(18)
                .floppyDisk(software)
                .build();
        Application application2 = Application.builder()
                .name("Writing app")
                .applicationSize(20)
                .floppyDisk(software)
                .build();
        Application application3 = Application.builder()
                .name("Printer firmware")
                .applicationSize(21)
                .floppyDisk(firmware)
                .build();
        Application application4 = Application.builder()
                .name("Microphone firmware")
                .applicationSize(28)
                .floppyDisk(firmware)
                .build();
        Application application5 = Application.builder()
                .name("Keyboard firmware")
                .applicationSize(22)
                .floppyDisk(firmware)
                .build();

        software.addCharacter(application1);
        software.addCharacter(application2);
        firmware.addCharacter(application3);
        firmware.addCharacter(application4);
        firmware.addCharacter(application5);

        // Task 3
        System.out.println("Task 3");
        Set<Application> applicationSet = List.of(software, firmware).stream()
                .flatMap(floppyDisk -> floppyDisk.getApplicationList().stream())
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
                        .profession(application.getFloppyDisk().getName())
                        .build())
                .sorted()
                .toList();
        System.out.println(applicationDtoList);

        // Task 6
        System.out.println("Task 6");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("floppyDisks.bin"))) {
            oos.writeObject(List.of(software, firmware));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("floppyDisks.bin"))) {
            List<FloppyDisk> floppyDisks = (List<FloppyDisk>) ois.readObject();
            floppyDisks.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Task 7
        System.out.println("Task 7");
        ForkJoinPool pool = new ForkJoinPool(3);
        Collection<FloppyDisk> floppyDisks = List.of(software, firmware);
        try {
            pool.submit(() -> {
                floppyDisks.stream()
                        .parallel()
                        .forEach(floppyDisk -> {
                            try {
                                Thread.sleep(1500);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println(floppyDisk);
                        });
            }).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}