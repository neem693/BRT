import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SnsJoinComponent } from './sns-join.component';

describe('SnsJoinComponent', () => {
  let component: SnsJoinComponent;
  let fixture: ComponentFixture<SnsJoinComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SnsJoinComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SnsJoinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
