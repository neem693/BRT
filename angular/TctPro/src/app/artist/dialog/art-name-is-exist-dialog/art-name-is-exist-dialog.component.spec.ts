import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtNameIsExistDialogComponent } from './art-name-is-exist-dialog.component';

describe('ArtNameIsExistDialogComponent', () => {
  let component: ArtNameIsExistDialogComponent;
  let fixture: ComponentFixture<ArtNameIsExistDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArtNameIsExistDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArtNameIsExistDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
