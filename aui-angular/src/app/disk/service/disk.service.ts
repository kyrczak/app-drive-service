import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Disks } from '../model/disks';
import { DiskDetails } from '../model/disk-details';
import { DiskForm } from '../model/disk-form';

@Injectable()
export class DiskService {

  constructor(private http: HttpClient) { }

  getDisks(): Observable<Disks> {
    return this.http.get<Disks>('/api/disks');
  }

  getDisk(uuid: string): Observable<DiskDetails> {
    return this.http.get<DiskDetails>('/api/disks/' + uuid);
  }

  deleteDisk(uuid: string): Observable<any> {
    return this.http.delete<DiskDetails>('/api/disks/' + uuid);
  }

  putDisk(uuid: string, request: DiskForm): Observable<any> {
    return this.http.put<DiskDetails>('/api/disks/' + uuid, request);
  }
}
