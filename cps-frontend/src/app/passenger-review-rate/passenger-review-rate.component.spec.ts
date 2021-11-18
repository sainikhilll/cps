import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PassengerReviewRateComponent } from './passenger-review-rate.component';

describe('PassengerReviewRateComponent', () => {
  let component: PassengerReviewRateComponent;
  let fixture: ComponentFixture<PassengerReviewRateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PassengerReviewRateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PassengerReviewRateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
