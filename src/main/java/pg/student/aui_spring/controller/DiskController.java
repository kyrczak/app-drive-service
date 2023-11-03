package pg.student.aui_spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pg.student.aui_spring.dto.GetApplicationsResponse;
import pg.student.aui_spring.dto.GetDiskResponse;
import pg.student.aui_spring.dto.GetDisksResponse;

import java.util.UUID;

public interface DiskController {
    @GetMapping("api/disks")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetDisksResponse getDisks();

    @GetMapping("api/disks/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetDiskResponse getDisk(
            @PathVariable("id")
            UUID id
    );

    @DeleteMapping("api/disks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    void deleteDisk(
            @PathVariable("id")
            UUID id
    );
}
