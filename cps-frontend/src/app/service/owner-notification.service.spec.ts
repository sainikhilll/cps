import { TestBed } from '@angular/core/testing';

import { OwnerNotificationService } from './owner-notification.service';

describe('OwnerNotificationService', () => {
  let service: OwnerNotificationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OwnerNotificationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
