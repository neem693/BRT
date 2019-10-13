import { TestBed } from '@angular/core/testing';

import { MemberServiceService } from './member-service.service';

describe('MemberServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MemberServiceService = TestBed.get(MemberServiceService);
    expect(service).toBeTruthy();
  });
});
