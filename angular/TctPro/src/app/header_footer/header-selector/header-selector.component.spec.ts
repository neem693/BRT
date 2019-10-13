import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderSelectorComponent } from './header-selector.component';

describe('HeaderSelectorComponent', () => {
  let component: HeaderSelectorComponent;
  let fixture: ComponentFixture<HeaderSelectorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaderSelectorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderSelectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
