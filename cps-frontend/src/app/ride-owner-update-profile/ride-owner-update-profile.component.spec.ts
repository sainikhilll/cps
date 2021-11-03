import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RideOwnerUpdateProfileComponent } from './ride-owner-update-profile.component';

describe('RideOwnerUpdateProfileComponent', () => {
  let component: RideOwnerUpdateProfileComponent;
  let fixture: ComponentFixture<RideOwnerUpdateProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RideOwnerUpdateProfileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RideOwnerUpdateProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
