import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DiskListComponent } from './disk/view/disk-list/disk-list.component';
import { DiskViewComponent } from './disk/view/disk-view/disk-view.component';
import { DiskAddComponent } from './disk/view/disk-add/disk-add.component';
import { DiskEditComponent } from './disk/view/disk-edit/disk-edit.component';

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
    component: DiskViewComponent,
    path: 'disks/:uuid'
  },  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
