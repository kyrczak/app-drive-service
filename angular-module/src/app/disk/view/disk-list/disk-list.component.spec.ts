import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiskListComponent } from './disk-list.component';

describe('DiskListComponent', () => {
  let component: DiskListComponent;
  let fixture: ComponentFixture<DiskListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DiskListComponent]
    });
    fixture = TestBed.createComponent(DiskListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
