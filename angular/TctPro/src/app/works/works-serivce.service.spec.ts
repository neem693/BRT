import { TestBed } from '@angular/core/testing';

import { WorksSerivceService } from './works-serivce.service';

describe('WorksSerivceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: WorksSerivceService = TestBed.get(WorksSerivceService);
    expect(service).toBeTruthy();
  });
});
