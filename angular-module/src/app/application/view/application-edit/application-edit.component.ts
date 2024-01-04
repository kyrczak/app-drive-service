import { Component, OnInit } from '@angular/core';
import { DiskForm } from 'src/app/disk/model/disk-form';
import { Disk } from 'src/app/disk/model/disk';
import { ApplicationService } from '../../service/application.service';
import { DiskService } from 'src/app/disk/service/disk.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ApplicationForm } from '../../model/application-form';

@Component({
  selector: 'app-application-edit',
  templateUrl: './application-edit.component.html',
  styleUrls: ['./application-edit.component.css']
})
export class ApplicationEditComponent implements OnInit{
    uuid: string | undefined;
    application: ApplicationForm | undefined;
    originalApplication: DiskForm | undefined;
    disk: Disk | undefined;

    constructor(
      private applicationService: ApplicationService,
      private diskService: DiskService,
      private route: ActivatedRoute,
      private router: Router
    ) {}

    ngOnInit(): void {
      this.route.params.subscribe(params => {
        this.diskService.getDisk(params['uuid']).subscribe(
          disk => {
            this.disk = disk;
          }
        );

        this.applicationService.getApplication(params['appuuid']).subscribe(
          application => {
            this.uuid = application.uuid;
            this.application = {
              name: application.name,
              size: application.size,
              disk: this.disk!.uuid
            };
            this.originalApplication = {...this.application};
          }
        );
      });
    }
  onSubmit(): void {
    if (this.application && this.originalApplication) {
      this.applicationService.patchApplication(this.uuid!, this.application!).subscribe(
        () => this.router.navigate(['/disks/'+this.application!.disk])
      );
    }
  }
}
