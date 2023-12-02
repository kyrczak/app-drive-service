import { Component } from '@angular/core';
import { ApplicationForm } from '../../model/application-form';
import { ApplicationService } from '../../service/application.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-application-add',
  templateUrl: './application-add.component.html',
  styleUrls: ['./application-add.component.css']
})
export class ApplicationAddComponent {
  diskUuid = this.route.snapshot.params['uuid'];
  uuid = '';
  application = {} as ApplicationForm;
  constructor(
    private applicationService: ApplicationService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  onSubmit(): void {
    this.application.disk = this.diskUuid;
    console.log(this.application);
    this.applicationService.putApplication(this.uuid!, this.application!).subscribe(
      () => this.router.navigate(['/disks/'+this.diskUuid])
    );
  }
  
}
