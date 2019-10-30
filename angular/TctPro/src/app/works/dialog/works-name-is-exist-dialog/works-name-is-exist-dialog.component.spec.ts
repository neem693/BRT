import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WorksNameIsExistDialogComponent } from './works-name-is-exist-dialog.component';

describe('WorksNameIsExistDialogComponent', () => {
  let component: WorksNameIsExistDialogComponent;
  let fixture: ComponentFixture<WorksNameIsExistDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WorksNameIsExistDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WorksNameIsExistDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
