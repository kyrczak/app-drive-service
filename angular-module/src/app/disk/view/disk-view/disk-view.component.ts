import { Component, OnInit } from '@angular/core';
import { DiskService } from '../../service/disk.service';
import { ActivatedRoute, Router } from '@angular/router';
import { DiskDetails } from '../../model/disk-details';
import { Applications } from 'src/app/application/model/applications';
import { ApplicationService } from 'src/app/application/service/application.service';
import { Application } from 'src/app/application/model/application';

@Component({
  selector: 'app-disk-view',
  templateUrl: './disk-view.component.html',
  styleUrls: ['./disk-view.component.css']
})
export class DiskViewComponent implements OnInit {
  disk: DiskDetails | undefined;
  disksApplications: Applications | undefined;

  constructor(private diskService: DiskService, private applicationService: ApplicationService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(){
    this.route.params.subscribe(params => {
      this.diskService.getDisk(params['uuid']).subscribe(disk => {
        this.disk = disk;
      });
      this.diskService.getDisksApplications(params['uuid']).subscribe(applications => {
        this.disksApplications = applications;
      });
    })
  }

  deleteApplicationFromDisk(application: Application) {
    this.applicationService.deleteApplication(application.uuid).subscribe(() => {
      this.ngOnInit();
    });
  }

}
