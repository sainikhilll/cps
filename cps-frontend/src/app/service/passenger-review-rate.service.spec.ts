import { TestBed } from '@angular/core/testing';

import { PassengerReviewRateService } from './passenger-review-rate.service';

describe('PassengerReviewRateService', () => {
  let service: PassengerReviewRateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PassengerReviewRateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
