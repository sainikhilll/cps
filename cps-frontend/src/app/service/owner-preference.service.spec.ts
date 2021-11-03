import { TestBed } from '@angular/core/testing';

import { OwnerPreferenceService } from './owner-preference.service';

describe('OwnerPreferenceService', () => {
  let service: OwnerPreferenceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OwnerPreferenceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
