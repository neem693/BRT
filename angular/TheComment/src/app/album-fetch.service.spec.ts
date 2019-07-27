import { TestBed } from '@angular/core/testing';

import { AlbumFetchService } from './album-fetch.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('AlbumFetchService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports :[HttpClientTestingModule]
  }));

  it('should be created', () => {
    const service: AlbumFetchService = TestBed.get(AlbumFetchService);
    expect(service).toBeTruthy();
  });
});
