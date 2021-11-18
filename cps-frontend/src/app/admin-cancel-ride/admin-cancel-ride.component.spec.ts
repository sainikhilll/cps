import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCancelRideComponent } from './admin-cancel-ride.component';

describe('AdminCancelRideComponent', () => {
  let component: AdminCancelRideComponent;
  let fixture: ComponentFixture<AdminCancelRideComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminCancelRideComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCancelRideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
