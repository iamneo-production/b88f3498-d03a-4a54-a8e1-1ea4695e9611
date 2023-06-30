import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GoaltrackingComponent } from './goaltracking.component';

describe('GoaltrackingComponent', () => {
  let component: GoaltrackingComponent;
  let fixture: ComponentFixture<GoaltrackingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GoaltrackingComponent]
    });
    fixture = TestBed.createComponent(GoaltrackingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
