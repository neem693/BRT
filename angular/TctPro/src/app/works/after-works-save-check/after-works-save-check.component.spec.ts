import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfterWorksSaveCheckComponent } from './after-works-save-check.component';

describe('AfterWorksSaveCheckComponent', () => {
  let component: AfterWorksSaveCheckComponent;
  let fixture: ComponentFixture<AfterWorksSaveCheckComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfterWorksSaveCheckComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfterWorksSaveCheckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
