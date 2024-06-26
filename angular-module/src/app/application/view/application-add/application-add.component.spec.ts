import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplicationAddComponent } from './application-add.component';

describe('ApplicationAddComponent', () => {
  let component: ApplicationAddComponent;
  let fixture: ComponentFixture<ApplicationAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ApplicationAddComponent]
    });
    fixture = TestBed.createComponent(ApplicationAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
