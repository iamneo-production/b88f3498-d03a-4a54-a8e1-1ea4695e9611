import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomNutritionRecomendationComponent } from './custom-nutrition-recomendation.component';

describe('CustomNutritionRecomendationComponent', () => {
  let component: CustomNutritionRecomendationComponent;
  let fixture: ComponentFixture<CustomNutritionRecomendationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomNutritionRecomendationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomNutritionRecomendationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
