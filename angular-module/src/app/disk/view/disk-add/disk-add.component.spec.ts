import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiskAddComponent } from './disk-add.component';

describe('DiskAddComponent', () => {
  let component: DiskAddComponent;
  let fixture: ComponentFixture<DiskAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DiskAddComponent]
    });
    fixture = TestBed.createComponent(DiskAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
