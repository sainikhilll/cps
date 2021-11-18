import { TestBed } from '@angular/core/testing';

import { AdminCancelRidesService } from './admin-cancel-rides.service';

describe('AdminCancelRidesService', () => {
  let service: AdminCancelRidesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminCancelRidesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
