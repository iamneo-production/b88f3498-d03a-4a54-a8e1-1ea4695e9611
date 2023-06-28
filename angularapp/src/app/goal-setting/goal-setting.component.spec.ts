import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GoalSettingComponent } from './goal-setting.component';

describe('GoalSettingComponent', () => {
  let component: GoalSettingComponent;
  let fixture: ComponentFixture<GoalSettingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GoalSettingComponent]
    });
    fixture = TestBed.createComponent(GoalSettingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
