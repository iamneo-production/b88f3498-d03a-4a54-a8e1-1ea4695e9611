import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuriyaComponent } from './suriya.component';

describe('SuriyaComponent', () => {
  let component: SuriyaComponent;
  let fixture: ComponentFixture<SuriyaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SuriyaComponent]
    });
    fixture = TestBed.createComponent(SuriyaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
