import { TestBed } from '@angular/core/testing';

import { PassengerRatingService } from './passenger-rating.service';

describe('PassengerRatingService', () => {
  let service: PassengerRatingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PassengerRatingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
