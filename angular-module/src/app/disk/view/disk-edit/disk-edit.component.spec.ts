import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiskEditComponent } from './disk-edit.component';

describe('DiskEditComponent', () => {
  let component: DiskEditComponent;
  let fixture: ComponentFixture<DiskEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DiskEditComponent]
    });
    fixture = TestBed.createComponent(DiskEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
