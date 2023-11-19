package pg.student.disk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pg.student.disk.dto.GetDiskResponse;
import pg.student.disk.dto.GetDisksResponse;
import pg.student.disk.dto.PutDiskRequest;

import java.util.UUID;

public interface DiskController {
    @GetMapping("api/disks")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetDisksResponse getDisks();

    @GetMapping("/api/disks/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetDiskResponse getDisk(
            @PathVariable("id")
            UUID id
    );

    @DeleteMapping("/api/disks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    void deleteDisk(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/disks/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    void putDisk(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutDiskRequest request
    );
}
