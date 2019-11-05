import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MatterSelectDialogComponent } from './matter-select-dialog.component';

describe('MatterSelectDialogComponent', () => {
  let component: MatterSelectDialogComponent;
  let fixture: ComponentFixture<MatterSelectDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MatterSelectDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MatterSelectDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
