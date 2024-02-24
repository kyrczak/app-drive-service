package pg.student.application_module.application.initialize;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pg.student.application_module.application.entity.Application;
import pg.student.application_module.application.service.ApplicationService;
import pg.student.application_module.disk.entity.Disk;
import pg.student.application_module.disk.service.DiskService;

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
        if (diskService.findAll().isEmpty()) {
            Disk software = Disk.builder()
                    .uuid(UUID.fromString("053073ac-6189-411b-b4f8-513742a2b3b1"))
                    .build();
            Disk firmware = Disk.builder()
                    .uuid(UUID.fromString("2e71dcc4-1845-43ea-aa46-22f2b5595a78"))
                    .build();
            Disk games = Disk.builder()
                    .uuid(UUID.fromString("012f799c-8754-4c5d-a997-a9cf83b5ff41"))
                    .build();

            diskService.create(software);
            diskService.create(firmware);
            diskService.create(games);

            Application paintingApp = Application.builder()
                    .uuid(UUID.fromString("599d305d-4884-4e45-9625-d47e3917950b"))
                    .name("Painting app")
                    .applicationSize(18)
                    .disk(software)
                    .build();
            Application writingApp = Application.builder()
                    .uuid(UUID.fromString("bc39ec9e-bc33-48a8-b752-89beecf486aa"))
                    .name("Writing app")
                    .applicationSize(20)
                    .disk(software)
                    .build();
            Application printerFirmware = Application.builder()
                    .uuid(UUID.fromString("e12e3cdc-2b9e-4e83-9a7c-4aac3a7a1191"))
                    .name("Printer firmware")
                    .applicationSize(21)
                    .disk(firmware)
                    .build();
            Application microphoneFirmware = Application.builder()
                    .uuid(UUID.fromString("91408223-4545-4f61-8a00-6740d11a5f32"))
                    .name("Microphone firmware")
                    .applicationSize(28)
                    .disk(firmware)
                    .build();
            Application keyboardFirmware = Application.builder()
                    .uuid(UUID.fromString("bcf45a82-34ae-452c-98a5-7dc23405a3f3"))
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
