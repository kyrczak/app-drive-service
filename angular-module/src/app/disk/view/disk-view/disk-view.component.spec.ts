import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiskViewComponent } from './disk-view.component';

describe('DiskViewComponent', () => {
  let component: DiskViewComponent;
  let fixture: ComponentFixture<DiskViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DiskViewComponent]
    });
    fixture = TestBed.createComponent(DiskViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
