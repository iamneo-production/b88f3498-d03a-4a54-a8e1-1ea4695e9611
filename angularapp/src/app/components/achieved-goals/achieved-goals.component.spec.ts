import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AchievedGoalsComponent } from './achieved-goals.component';

describe('AchievedGoalsComponent', () => {
  let component: AchievedGoalsComponent;
  let fixture: ComponentFixture<AchievedGoalsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AchievedGoalsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AchievedGoalsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
