import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EvalSerachComponent } from './eval-serach.component';

describe('EvalSerachComponent', () => {
  let component: EvalSerachComponent;
  let fixture: ComponentFixture<EvalSerachComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EvalSerachComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EvalSerachComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
