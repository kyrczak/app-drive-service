import { Component, OnInit } from '@angular/core';
import { DiskForm } from '../../model/disk-form';
import { DiskService } from '../../service/disk.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-disk-edit',
  templateUrl: './disk-edit.component.html',
  styleUrls: ['./disk-edit.component.css']
})
export class DiskEditComponent implements OnInit{
  uuid: string | undefined;
  disk: DiskForm | undefined;
  originalDisk: DiskForm | undefined;
  
  constructor(
    private diskService: DiskService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.diskService.getDisk(params['uuid']).subscribe(
        disk => {
          this.uuid = disk.uuid;
          this.disk = {
            name: disk.name,
            size: disk.size
          };
          this.originalDisk = {...this.disk};
        }
      );
    });
  }

  onSubmit(): void {
    if (this.disk && this.originalDisk) {
      this.diskService.patchDisk(this.uuid!, this.disk!).subscribe(
        () => this.router.navigate(['/disks'])
      );
    }
  }
}
