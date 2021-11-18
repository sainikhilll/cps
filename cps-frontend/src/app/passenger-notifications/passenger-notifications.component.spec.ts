import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PassengerNotificationsComponent } from './passenger-notifications.component';

describe('PassengerNotificationsComponent', () => {
  let component: PassengerNotificationsComponent;
  let fixture: ComponentFixture<PassengerNotificationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PassengerNotificationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PassengerNotificationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
