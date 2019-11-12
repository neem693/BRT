import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkSerachComponent } from './work-serach.component';

describe('WorkSerachComponent', () => {
  let component: WorkSerachComponent;
  let fixture: ComponentFixture<WorkSerachComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WorkSerachComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WorkSerachComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
