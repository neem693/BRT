import { TestBed } from '@angular/core/testing';

import { GlobalServiceService } from './global-service.service';

describe('GlobalServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GlobalServiceService = TestBed.get(GlobalServiceService);
    expect(service).toBeTruthy();
  });
});
