import { TestBed } from '@angular/core/testing';

import { WorksdataService } from './worksdata.service';

describe('WorksdataService', () => {
  let service: WorksdataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WorksdataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
