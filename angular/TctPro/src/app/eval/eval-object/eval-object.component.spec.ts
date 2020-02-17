import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EvalObjectComponent } from './eval-object.component';

describe('EvalObjectComponent', () => {
  let component: EvalObjectComponent;
  let fixture: ComponentFixture<EvalObjectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EvalObjectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EvalObjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
