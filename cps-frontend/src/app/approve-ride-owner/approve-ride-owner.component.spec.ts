import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApproveRideOwnerComponent } from './approve-ride-owner.component';

describe('ApproveRideOwnerComponent', () => {
  let component: ApproveRideOwnerComponent;
  let fixture: ComponentFixture<ApproveRideOwnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApproveRideOwnerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ApproveRideOwnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
