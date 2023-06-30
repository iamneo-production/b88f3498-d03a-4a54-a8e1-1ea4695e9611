import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HtwtcompComponent } from './htwtcomp.component';

describe('HtwtcompComponent', () => {
  let component: HtwtcompComponent;
  let fixture: ComponentFixture<HtwtcompComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HtwtcompComponent]
    });
    fixture = TestBed.createComponent(HtwtcompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
