package pg.student.aui_spring.initialize;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pg.student.aui_spring.entity.Application;
import pg.student.aui_spring.entity.Disk;
import pg.student.aui_spring.service.ApplicationService;
import pg.student.aui_spring.service.DiskService;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final ApplicationService applicationService;
    private final DiskService diskService;

    @Autowired
    public InitializeData(
            ApplicationService applicationService,
            DiskService diskService
    ) {
        this.applicationService = applicationService;
        this.diskService = diskService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (diskService.find("software").isEmpty()) {
            Disk software = Disk.builder()
                    .uuid(UUID.randomUUID())
                    .name("software")
                    .diskSize(1024)
                    .build();
            Disk firmware = Disk.builder()
                    .uuid(UUID.randomUUID())
                    .name("firmware")
                    .diskSize(128)
                    .build();

            diskService.create(software);
            diskService.create(firmware);

            Application paintingApp = Application.builder()
                    .uuid(UUID.randomUUID())
                    .name("Painting app")
                    .applicationSize(18)
                    .disk(software)
                    .build();
            Application writingApp = Application.builder()
                    .uuid(UUID.randomUUID())
                    .name("Writing app")
                    .applicationSize(20)
                    .disk(software)
                    .build();
            Application printerFirmware = Application.builder()
                    .uuid(UUID.randomUUID())
                    .name("Printer firmware")
                    .applicationSize(21)
                    .disk(firmware)
                    .build();
            Application microphoneFirmware = Application.builder()
                    .uuid(UUID.randomUUID())
                    .name("Microphone firmware")
                    .applicationSize(28)
                    .disk(firmware)
                    .build();
            Application keyboardFirmware = Application.builder()
                    .uuid(UUID.randomUUID())
                    .name("Keyboard firmware")
                    .applicationSize(22)
                    .disk(firmware)
                    .build();

            applicationService.create(paintingApp);
            applicationService.create(writingApp);
            applicationService.create(keyboardFirmware);
            applicationService.create(printerFirmware);
            applicationService.create(microphoneFirmware);
        }
    }
}
