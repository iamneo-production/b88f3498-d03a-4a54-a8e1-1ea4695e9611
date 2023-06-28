import { TestBed } from '@angular/core/testing';

import { GoalsettingService } from './goalsetting.service';

describe('GoalsettingService', () => {
  let service: GoalsettingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GoalsettingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
