import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PassengerCancelTripComponent } from './passenger-cancel-trip.component';

describe('PassengerCancelTripComponent', () => {
  let component: PassengerCancelTripComponent;
  let fixture: ComponentFixture<PassengerCancelTripComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PassengerCancelTripComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PassengerCancelTripComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
