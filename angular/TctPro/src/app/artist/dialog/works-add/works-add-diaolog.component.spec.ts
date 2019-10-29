import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WorksAddComponent } from './works-add-diaolog.component';

describe('WorksAddComponent', () => {
  let component: WorksAddComponent;
  let fixture: ComponentFixture<WorksAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WorksAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WorksAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
