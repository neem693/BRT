import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JoinFailComponent } from './join-fail.component';

describe('JoinFailComponent', () => {
  let component: JoinFailComponent;
  let fixture: ComponentFixture<JoinFailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JoinFailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JoinFailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
