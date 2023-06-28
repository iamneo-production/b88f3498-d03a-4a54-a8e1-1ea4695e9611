import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkouthistoryComponent } from './workouthistory.component';

describe('WorkouthistoryComponent', () => {
  let component: WorkouthistoryComponent;
  let fixture: ComponentFixture<WorkouthistoryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WorkouthistoryComponent]
    });
    fixture = TestBed.createComponent(WorkouthistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
