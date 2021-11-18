import { TestBed } from '@angular/core/testing';

import { PassengerCancelTripService } from './passenger-cancel-trip.service';

describe('PassengerCancelTripService', () => {
  let service: PassengerCancelTripService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PassengerCancelTripService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
