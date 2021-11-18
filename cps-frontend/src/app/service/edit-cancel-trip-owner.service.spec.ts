import { TestBed } from '@angular/core/testing';

import { EditCancelTripOwnerService } from './edit-cancel-trip-owner.service';

describe('EditCancelTripOwnerService', () => {
  let service: EditCancelTripOwnerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EditCancelTripOwnerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
