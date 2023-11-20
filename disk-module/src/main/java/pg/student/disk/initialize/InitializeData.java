package pg.student.disk.initialize;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pg.student.disk.service.DiskService;
import pg.student.disk.entity.Disk;
import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final DiskService diskService;

    @Autowired
    public InitializeData(
            DiskService diskService
    ) {
        this.diskService = diskService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (diskService.findAll().isEmpty()) {
            Disk software = Disk.builder()
                    .uuid(UUID.fromString("053073ac-6189-411b-b4f8-513742a2b3b1"))
                    .name("software")
                    .diskSize(1024)
                    .build();
            Disk firmware = Disk.builder()
                    .uuid(UUID.fromString("2e71dcc4-1845-43ea-aa46-22f2b5595a78"))
                    .name("firmware")
                    .diskSize(128)
                    .build();
            Disk games = Disk.builder()
                    .uuid(UUID.fromString("012f799c-8754-4c5d-a997-a9cf83b5ff41"))
                    .name("games")
                    .diskSize(512)
                    .build();

            diskService.initializeCreate(software);
            diskService.initializeCreate(firmware);
            diskService.initializeCreate(games);
        }
    }
}
