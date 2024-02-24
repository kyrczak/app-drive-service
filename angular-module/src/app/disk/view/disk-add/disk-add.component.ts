import { Component, OnInit } from '@angular/core';
import { DiskForm } from '../../model/disk-form';
import { DiskService } from '../../service/disk.service';
import { ActivatedRoute, Router } from '@angular/router';
import { DiskDetails } from '../../model/disk-details';

@Component({
  selector: 'app-disk-add',
  templateUrl: './disk-add.component.html',
  styleUrls: ['./disk-add.component.css']
})
export class DiskAddComponent {
    uuid = '';
    disk = {} as DiskForm;
    originalDisk: DiskDetails | undefined;
    constructor(
      private diskService: DiskService,
      private route: ActivatedRoute,
      private router: Router
    ) {}
    
    onSubmit(): void {
      this.diskService.putDisk(this.uuid!, this.disk!).subscribe(
        () => this.router.navigate(['/disks'])
      );
    }      
      
}
