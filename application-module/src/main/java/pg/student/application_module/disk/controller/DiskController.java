package pg.student.application_module.disk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pg.student.application_module.disk.dto.PutDiskRequest;

import java.util.UUID;

public interface DiskController {
    @DeleteMapping("/api/disks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    void deleteDisk(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/disks/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putDisk(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutDiskRequest request
    );
}
