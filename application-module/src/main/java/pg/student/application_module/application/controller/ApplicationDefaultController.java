package pg.student.application_module.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pg.student.application_module.application.dto.GetApplicationResponse;
import pg.student.application_module.application.dto.GetApplicationsResponse;
import pg.student.application_module.application.dto.PatchApplicationRequest;
import pg.student.application_module.application.dto.PutApplicationRequest;
import pg.student.application_module.application.function.ApplicationToResponseFunction;
import pg.student.application_module.application.function.ApplicationsToResponseFunction;
import pg.student.application_module.application.function.RequestToApplicationFunction;
import pg.student.application_module.application.service.ApplicationService;

import java.util.UUID;

@RestController
public class ApplicationDefaultController implements ApplicationController {
    private final ApplicationService service;
    private final ApplicationToResponseFunction applicationToResponse;
    private final ApplicationsToResponseFunction applicationsToResponse;
    private final RequestToApplicationFunction requestToApplication;

    @Autowired
    ApplicationDefaultController(
            ApplicationService service,
            ApplicationToResponseFunction applicationToResponseFunction,
            ApplicationsToResponseFunction applicationsToResponse,
            RequestToApplicationFunction requestToApplication
    ) {
        this.service = service;
        this.applicationToResponse = applicationToResponseFunction;
        this.applicationsToResponse = applicationsToResponse;
        this.requestToApplication = requestToApplication;
    }

    @Override
    public GetApplicationsResponse getApplications() {
        return applicationsToResponse.apply(service.findAll());
    }

    @Override
    public GetApplicationsResponse getDisksApplications(UUID diskID) {
        return service.findAllByDisk(diskID)
                .map(applicationsToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetApplicationResponse getApplication(UUID id) {
        return service.find(id)
                .map(applicationToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetApplicationResponse getDisksApplication(UUID diskId, UUID applicationId) {
        return service.findByDiskAndId(diskId,applicationId)
                .map(applicationToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @Override
    public void putApplication(UUID id, PutApplicationRequest request) {
        service.find(id).ifPresentOrElse(
                application -> {throw new ResponseStatusException(HttpStatus.FORBIDDEN);},
                () -> {
                    service.create(requestToApplication.apply(id,request));
                }
        );
    }

    @Override
    public void updateApplication(UUID id, PatchApplicationRequest request) {
        service.find(id).ifPresentOrElse(
                application -> {
                    application.setName(request.getName());
                    application.setApplicationSize(request.getSize());
                    service.update(application);
                },
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }

        );
    }

    @Override
    public void deleteApplication(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        application -> service.delete(application.getName()),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
