import { TestBed } from '@angular/core/testing';

import { TripBookingService } from './trip-booking.service';

describe('TripBookingService', () => {
  let service: TripBookingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TripBookingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
