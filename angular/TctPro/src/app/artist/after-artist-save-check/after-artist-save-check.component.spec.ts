import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfterArtistSaveCheckComponent } from './after-artist-save-check.component';

describe('AfterArtistSaveCheckComponent', () => {
  let component: AfterArtistSaveCheckComponent;
  let fixture: ComponentFixture<AfterArtistSaveCheckComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfterArtistSaveCheckComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfterArtistSaveCheckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
