import { Component, OnInit } from '@angular/core';
import { DiskService } from '../../service/disk.service';
import { Disks } from '../../model/disks';
import { Disk } from '../../model/disk';


@Component({
  selector: 'app-disk-list',
  templateUrl: './disk-list.component.html',
  styleUrls: ['./disk-list.component.css']
})
export class DiskListComponent implements OnInit {
  constructor(private diskService: DiskService) { }

  disks: Disks | undefined;
  ngOnInit(): void {
    this.diskService.getDisks().subscribe(data => {
      this.disks = data;
    });
  }

  onDelete(disk: Disk): void {
    this.diskService.deleteDisk(disk.uuid).subscribe(() => {
      this.ngOnInit();
    });
  }
}
