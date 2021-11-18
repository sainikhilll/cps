import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditCancelTripOwnerComponent } from './edit-cancel-trip-owner.component';

describe('EditCancelTripOwnerComponent', () => {
  let component: EditCancelTripOwnerComponent;
  let fixture: ComponentFixture<EditCancelTripOwnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditCancelTripOwnerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditCancelTripOwnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
