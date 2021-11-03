import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewRideOwnersComponent } from './view-ride-owners.component';

describe('ViewRideOwnersComponent', () => {
  let component: ViewRideOwnersComponent;
  let fixture: ComponentFixture<ViewRideOwnersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewRideOwnersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewRideOwnersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
