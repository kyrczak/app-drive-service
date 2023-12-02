import { Component, OnInit } from '@angular/core';
import { ApplicationDetails } from '../../model/application-details';
import { DiskDetails } from 'src/app/disk/model/disk-details';
import { ApplicationService } from '../../service/application.service';
import { DiskService } from 'src/app/disk/service/disk.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-application-view',
  templateUrl: './application-view.component.html',
  styleUrls: ['./application-view.component.css']
})
export class ApplicationViewComponent implements OnInit{
  application: ApplicationDetails | undefined;
  disk: DiskDetails | undefined;

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
          this.application = application;
        }
      );
    });
  }
}
