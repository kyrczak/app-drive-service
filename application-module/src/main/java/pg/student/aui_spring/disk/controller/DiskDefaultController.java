package pg.student.aui_spring.disk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pg.student.aui_spring.disk.service.DiskService;

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
                                disk -> service.delete(disk.getName()),
                                () -> {
                                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                                }
                        );
        }

}
