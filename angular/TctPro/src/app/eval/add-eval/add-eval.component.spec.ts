import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEvalComponent } from './add-eval.component';

describe('AddEvalComponent', () => {
  let component: AddEvalComponent;
  let fixture: ComponentFixture<AddEvalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddEvalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEvalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
