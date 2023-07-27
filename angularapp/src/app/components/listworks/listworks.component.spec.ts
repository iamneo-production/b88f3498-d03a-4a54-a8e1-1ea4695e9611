import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListworksComponent } from './listworks.component';

describe('ListworksComponent', () => {
  let component: ListworksComponent;
  let fixture: ComponentFixture<ListworksComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListworksComponent]
    });
    fixture = TestBed.createComponent(ListworksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
