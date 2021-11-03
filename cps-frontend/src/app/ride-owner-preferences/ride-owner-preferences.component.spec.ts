import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RideOwnerPreferencesComponent } from './ride-owner-preferences.component';

describe('RideOwnerPreferencesComponent', () => {
  let component: RideOwnerPreferencesComponent;
  let fixture: ComponentFixture<RideOwnerPreferencesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RideOwnerPreferencesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RideOwnerPreferencesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
