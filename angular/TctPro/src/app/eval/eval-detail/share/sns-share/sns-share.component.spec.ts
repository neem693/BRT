import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SnsShareComponent } from './sns-share.component';

describe('SnsShareComponent', () => {
  let component: SnsShareComponent;
  let fixture: ComponentFixture<SnsShareComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SnsShareComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SnsShareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
