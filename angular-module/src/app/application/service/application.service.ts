import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Applications } from '../model/applications';
import { ApplicationDetails } from '../model/application-details';
import { ApplicationForm } from '../model/application-form';

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  constructor(private http: HttpClient) { }

  getApplications(): Observable<Applications> {
    return this.http.get<Applications>('/api/applications');
  }
  getApplication(uuid: string): Observable<ApplicationDetails> {
    return this.http.get<ApplicationDetails>('/api/applications/' + uuid);
  }

  deleteApplication(uuid: string): Observable<any> {
    return this.http.delete<ApplicationDetails>('/api/applications/' + uuid);
  }

  putApplication(uuid: string, request: ApplicationForm): Observable<any> {
    return this.http.put<ApplicationDetails>('/api/applications/' + uuid, request);
  }

  patchApplication(uuid: string, request: ApplicationForm): Observable<any> {
    return this.http.patch<ApplicationDetails>('/api/applications/' + uuid, request);
  }

  putApplicationOnDisk(diskUuid: string, applicationUuid: string, request: ApplicationForm): Observable<any> {
    return this.http.put<ApplicationDetails>('/api/disks/' + diskUuid + '/applications/' + applicationUuid, request);
  }

  patchApplicationOnDisk(diskUuid: string, applicationUuid: string, request: ApplicationForm): Observable<any> {
    return this.http.patch<ApplicationDetails>('/api/disks/' + diskUuid + '/applications/' + applicationUuid, request);
  }
}
