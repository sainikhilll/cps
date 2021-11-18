import { TestBed } from '@angular/core/testing';

import { AdminViewRidesService } from './admin-view-rides.service';

describe('AdminViewRidesService', () => {
  let service: AdminViewRidesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminViewRidesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
