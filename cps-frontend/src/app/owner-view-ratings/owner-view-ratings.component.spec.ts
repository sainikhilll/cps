import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerViewRatingsComponent } from './owner-view-ratings.component';

describe('OwnerViewRatingsComponent', () => {
  let component: OwnerViewRatingsComponent;
  let fixture: ComponentFixture<OwnerViewRatingsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OwnerViewRatingsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OwnerViewRatingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
