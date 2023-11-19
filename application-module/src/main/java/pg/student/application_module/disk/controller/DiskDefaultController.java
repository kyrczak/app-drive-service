package pg.student.application_module.disk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pg.student.application_module.disk.dto.PutDiskRequest;
import pg.student.application_module.disk.function.RequestToDiskFunction;
import pg.student.application_module.disk.service.DiskService;

import java.util.UUID;

@RestController
public class DiskDefaultController implements DiskController {
        private final DiskService service;
        private final RequestToDiskFunction requestToDiskFunction;
        @Autowired
        DiskDefaultController(
                DiskService service,
                RequestToDiskFunction requestToDiskFunction
        ) {
                this.service = service;
                this.requestToDiskFunction = requestToDiskFunction;
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

        @Override
        public void putDisk(UUID id, PutDiskRequest request) {
                service.find(id).ifPresentOrElse(
                        disk -> {throw new ResponseStatusException(HttpStatus.FORBIDDEN);},
                        () -> {
                                service.create(requestToDiskFunction.apply(id, request));
                        }
                );
        }
}
