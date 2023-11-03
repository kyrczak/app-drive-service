package pg.student.aui_spring.controller;

import jakarta.persistence.OneToMany;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pg.student.aui_spring.dto.GetApplicationResponse;
import pg.student.aui_spring.dto.GetApplicationsResponse;
import pg.student.aui_spring.dto.PutApplicationRequest;

import java.util.UUID;

public interface ApplicationController {
    @GetMapping("api/applications")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetApplicationsResponse getApplications();

    @GetMapping("/api/disks/{diskId}/applications")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetApplicationsResponse getDisksApplications(
            @PathVariable("diskId")
            UUID diskID
    );

    @GetMapping("/api/applications/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetApplicationResponse getApplication(
            @PathVariable("id")
            UUID id
    );

    @GetMapping("/api/disks/{diskId}/applications/{applicationId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetApplicationResponse getDisksApplication(
            @PathVariable("diskId")
            UUID diskId,
            @PathVariable("applicationId")
            UUID applicationId
    );

    @PutMapping("/api/applications/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putApplication(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutApplicationRequest request
    );

    @DeleteMapping("/api/applications/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteApplication(
            @PathVariable("id")
            UUID id
    );


}
