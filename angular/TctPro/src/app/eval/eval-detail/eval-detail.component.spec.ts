import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EvalDetailComponent } from './eval-detail.component';

describe('EvalDetailComponent', () => {
  let component: EvalDetailComponent;
  let fixture: ComponentFixture<EvalDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EvalDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EvalDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
