package pg.student.application_module.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pg.student.application_module.application.dto.GetApplicationResponse;
import pg.student.application_module.application.dto.GetApplicationsResponse;
import pg.student.application_module.application.dto.PatchApplicationRequest;
import pg.student.application_module.application.dto.PutApplicationRequest;

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

    @PatchMapping("/api/applications/{id}")
    @ResponseStatus(HttpStatus.OK)
    void updateApplication(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchApplicationRequest request
    );

    @DeleteMapping("/api/applications/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteApplication(
            @PathVariable("id")
            UUID id
    );


}
