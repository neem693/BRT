import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FooterSelectorComponent } from './footer-selector.component';

describe('FooterSelectorComponent', () => {
  let component: FooterSelectorComponent;
  let fixture: ComponentFixture<FooterSelectorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FooterSelectorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FooterSelectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
