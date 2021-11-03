import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RideOwnerSignupComponent } from './ride-owner-signup.component';

describe('RideOwnerSignupComponent', () => {
  let component: RideOwnerSignupComponent;
  let fixture: ComponentFixture<RideOwnerSignupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RideOwnerSignupComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RideOwnerSignupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
