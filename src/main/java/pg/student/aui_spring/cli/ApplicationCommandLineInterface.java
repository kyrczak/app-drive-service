package pg.student.aui_spring.cli;

import ch.qos.logback.core.net.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pg.student.aui_spring.entity.Application;
import pg.student.aui_spring.service.ApplicationService;
import pg.student.aui_spring.service.DiskService;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

@Component
public class ApplicationCommandLineInterface implements CommandLineRunner {
    private final ApplicationService applicationService;
    private final DiskService diskService;

    @Autowired
    public ApplicationCommandLineInterface(
            ApplicationService applicationService,
            DiskService diskService
    ) {
        this.applicationService = applicationService;
        this.diskService = diskService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String command;
        main_loop:
        while(true) {
            printMenu();
            command = scanner.next();
            switch (command) {
                case "1" -> {
                    applicationService.findAll().forEach(System.out::println);
                }
                case "2" -> {
                    diskService.findAll().forEach(System.out::println);
                }
                case "3" -> {
                    UUID uuid = UUID.randomUUID();
                    System.out.print("Please input application name: ");
                    String name = scanner.next();
                    System.out.print("Please input application disk: ");
                    String disk = scanner.next();
                    System.out.print("Please input application size: ");
                    int appSize = Integer.parseInt(scanner.next());
                    Application application = Application.builder()
                            .uuid(uuid)
                            .name(name)
                            .disk(diskService.find(disk).orElseThrow(NoSuchElementException::new))
                            .applicationSize(appSize)
                            .build();
                    applicationService.create(application);
                }
                case "4" -> {
                    System.out.print("Please input application name to delete: ");
                    String appName = scanner.next();
                    applicationService.delete(appName);
                }
                case "5" -> {
                    break main_loop;
                }
            }
        }
    }

    private void printMenu() {
        System.out.println("Please input a number to choose one of the following options");
        System.out.println("1. Get all applications");
        System.out.println("2. Get all disks");
        System.out.println("3. Add new application");
        System.out.println("4. Delete existing application");
        System.out.println("5. Stop this program");
    }
}
