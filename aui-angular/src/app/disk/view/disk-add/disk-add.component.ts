import { Component, OnInit } from '@angular/core';
import { DiskForm } from '../../model/disk-form';
import { DiskService } from '../../service/disk.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-disk-add',
  templateUrl: './disk-add.component.html',
  styleUrls: ['./disk-add.component.css']
})
export class DiskAddComponent implements OnInit{
    disk = {} as DiskForm;
    constructor(
      private diskService: DiskService,
      private route: ActivatedRoute,
      private router: Router
    ) {}

    ngOnInit(): void {
      
    }

    onSubmit(): void {
      console.log(this.disk!);
    }      
      
}
