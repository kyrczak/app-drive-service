import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ApplicationViewComponent } from './application/view/application-view/application-view.component';
import { DiskViewComponent } from './disk/view/disk-view/disk-view.component';
import { DiskService } from './disk/service/disk.service';
import { ApplicationService } from './application/service/application.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { DiskListComponent } from './disk/view/disk-list/disk-list.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { DiskAddComponent } from './disk/view/disk-add/disk-add.component';
import { DiskEditComponent } from './disk/view/disk-edit/disk-edit.component';
import { ApplicationAddComponent } from './application/view/application-add/application-add.component';
import { ApplicationEditComponent } from './application/view/application-edit/application-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    ApplicationViewComponent,
    DiskViewComponent,
    DiskListComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    MainComponent,
    DiskAddComponent,
    DiskEditComponent,
    ApplicationAddComponent,
    ApplicationEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    DiskService,
    ApplicationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
