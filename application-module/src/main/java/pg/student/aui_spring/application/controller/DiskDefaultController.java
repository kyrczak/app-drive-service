package pg.student.aui_spring.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pg.student.aui_spring.application.dto.GetDiskResponse;
import pg.student.aui_spring.application.dto.GetDisksResponse;

import java.util.UUID;

@RestController
public class DiskDefaultController implements DiskController {
        private final DiskService service;
        private final DiskToResponseFunction diskToResponse;
        private final DisksToResponseFunction disksToResponse;
        private final RequestToDiskFunction requestToDisk;

        @Autowired
        DiskDefaultController(
                DiskService service,
                DiskToResponseFunction diskToResponse,
                DisksToResponseFunction disksToResponse,
                RequestToDiskFunction requestToDisk
        ) {
                this.service = service;
                this.disksToResponse = disksToResponse;
                this.diskToResponse = diskToResponse;
                this.requestToDisk = requestToDisk;
        }

        @Override
        public GetDisksResponse getDisks() {
                return disksToResponse.apply(service.findAll());
        }

        @Override
        public GetDiskResponse getDisk(UUID id) {
                return service.find(id)
                        .map(diskToResponse)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
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
