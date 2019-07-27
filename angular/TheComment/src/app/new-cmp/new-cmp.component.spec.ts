import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { NewCmpComponent } from './new-cmp.component';
import {HttpClientTestingModule} from '@angular/common/http/testing'

describe('NewCmpComponent', () => {
  let component: NewCmpComponent;
  let fixture: ComponentFixture<NewCmpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewCmpComponent ],
      imports:[HttpClientTestingModule],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewCmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
