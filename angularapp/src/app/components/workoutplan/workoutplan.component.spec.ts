import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkoutplanComponent } from './workoutplan.component';

describe('WorkoutplanComponent', () => {
  let component: WorkoutplanComponent;
  let fixture: ComponentFixture<WorkoutplanComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WorkoutplanComponent]
    });
    fixture = TestBed.createComponent(WorkoutplanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
