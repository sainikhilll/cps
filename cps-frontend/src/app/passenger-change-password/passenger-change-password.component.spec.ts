import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PassengerChangePasswordComponent } from './passenger-change-password.component';

describe('PassengerChangePasswordComponent', () => {
  let component: PassengerChangePasswordComponent;
  let fixture: ComponentFixture<PassengerChangePasswordComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PassengerChangePasswordComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PassengerChangePasswordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
