import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PassengerRatingComponent } from './passenger-rating.component';

describe('PassengerRatingComponent', () => {
  let component: PassengerRatingComponent;
  let fixture: ComponentFixture<PassengerRatingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PassengerRatingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PassengerRatingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
