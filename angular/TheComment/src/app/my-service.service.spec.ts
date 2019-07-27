import { TestBed } from '@angular/core/testing';

import { MyServiceService } from './my-service.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('MyServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [HttpClientTestingModule]
  }));

  it('should be created', () => {
    const service: MyServiceService = TestBed.get(MyServiceService);
    expect(service).toBeTruthy();
  });
});
