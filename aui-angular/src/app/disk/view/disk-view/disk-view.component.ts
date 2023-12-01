import { Component, OnInit } from '@angular/core';
import { DiskService } from '../../service/disk.service';
import { ActivatedRoute, Router } from '@angular/router';
import { DiskDetails } from '../../model/disk-details';

@Component({
  selector: 'app-disk-view',
  templateUrl: './disk-view.component.html',
  styleUrls: ['./disk-view.component.css']
})
export class DiskViewComponent implements OnInit {
  disk: DiskDetails | undefined;
  constructor(private diskService: DiskService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(){
    this.route.params.subscribe(params => {
      this.diskService.getDisk(params['uuid']).subscribe(disk => {
        this.disk = disk;
      });
    })
  }

}
