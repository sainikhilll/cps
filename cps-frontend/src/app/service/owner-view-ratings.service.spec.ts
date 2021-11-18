import { TestBed } from '@angular/core/testing';

import { OwnerViewRatingsService } from './owner-view-ratings.service';

describe('OwnerViewRatingsService', () => {
  let service: OwnerViewRatingsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OwnerViewRatingsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
