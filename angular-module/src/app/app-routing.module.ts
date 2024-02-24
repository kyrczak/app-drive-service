import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DiskListComponent } from './disk/view/disk-list/disk-list.component';
import { DiskViewComponent } from './disk/view/disk-view/disk-view.component';
import { DiskAddComponent } from './disk/view/disk-add/disk-add.component';
import { DiskEditComponent } from './disk/view/disk-edit/disk-edit.component';
import { ApplicationAddComponent } from './application/view/application-add/application-add.component';
import { ApplicationEditComponent } from './application/view/application-edit/application-edit.component';
import { ApplicationViewComponent } from './application/view/application-view/application-view.component';

const routes: Routes = [
  { 
    component: DiskListComponent,
    path: 'disks'
  },
  {
    component: DiskAddComponent,
    path: 'disks/add'
  },
  {
    component: DiskEditComponent,
    path: 'disks/:uuid/edit'
  },
  {
    component: ApplicationAddComponent,
    path: 'disks/:uuid/add'
  },
  {
    component: DiskViewComponent,
    path: 'disks/:uuid'
  },
  {
    component: ApplicationEditComponent,
    path: 'disks/:uuid/applications/:appuuid/edit'
  },
  {
    component: ApplicationViewComponent,
    path: 'disks/:uuid/applications/:appuuid'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
