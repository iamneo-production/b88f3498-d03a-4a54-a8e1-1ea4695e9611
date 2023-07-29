import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatetrackingComponent } from './datetracking.component';

describe('DatetrackingComponent', () => {
  let component: DatetrackingComponent;
  let fixture: ComponentFixture<DatetrackingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DatetrackingComponent]
    });
    fixture = TestBed.createComponent(DatetrackingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
