import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminViewRidesComponent } from './admin-view-rides.component';

describe('AdminViewRidesComponent', () => {
  let component: AdminViewRidesComponent;
  let fixture: ComponentFixture<AdminViewRidesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminViewRidesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminViewRidesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
