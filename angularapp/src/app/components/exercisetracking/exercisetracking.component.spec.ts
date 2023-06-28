import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExercisetrackingComponent } from './exercisetracking.component';

describe('ExercisetrackingComponent', () => {
  let component: ExercisetrackingComponent;
  let fixture: ComponentFixture<ExercisetrackingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ExercisetrackingComponent]
    });
    fixture = TestBed.createComponent(ExercisetrackingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
