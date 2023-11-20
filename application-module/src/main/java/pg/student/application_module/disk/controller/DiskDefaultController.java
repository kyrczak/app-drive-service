package pg.student.application_module.disk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pg.student.application_module.disk.entity.Disk;
import pg.student.application_module.disk.service.DiskService;

import java.util.UUID;

@RestController
public class DiskDefaultController implements DiskController {
        private final DiskService service;
        @Autowired
        DiskDefaultController(
                DiskService service
        ) {
                this.service = service;
        }

        @Override
        public void deleteDisk(UUID id) {
                service.find(id)
                        .ifPresentOrElse(
                                disk -> service.delete(id),
                                () -> {
                                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                                }
                        );
        }

        @Override
        public void putDisk(UUID id) {
                service.find(id).ifPresentOrElse(
                        disk -> {throw new ResponseStatusException(HttpStatus.FORBIDDEN);},
                        () -> {
                                service.create(
                                        Disk.builder()
                                                .uuid(id)
                                                .build());
                        }
                );
        }
}
