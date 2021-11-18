import { TestBed } from '@angular/core/testing';

import { PassengerNotificationsService } from './passenger-notifications.service';

describe('PassengerNotificationsService', () => {
  let service: PassengerNotificationsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PassengerNotificationsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
