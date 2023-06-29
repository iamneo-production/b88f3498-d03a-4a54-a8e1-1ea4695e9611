import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GoalsettingComponent } from './goalsetting.component';

describe('GoalsettingComponent', () => {
  let component: GoalsettingComponent;
  let fixture: ComponentFixture<GoalsettingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GoalsettingComponent]
    });
    fixture = TestBed.createComponent(GoalsettingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
