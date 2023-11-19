package pg.student.aui_spring.disk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pg.student.aui_spring.application.dto.GetDiskResponse;
import pg.student.aui_spring.application.dto.GetDisksResponse;

import java.util.UUID;

public interface DiskController {
    @DeleteMapping("/api/disks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    void deleteDisk(
            @PathVariable("id")
            UUID id
    );
}
