import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewreporterComponent } from './viewreporter.component';

describe('ViewreporterComponent', () => {
  let component: ViewreporterComponent;
  let fixture: ComponentFixture<ViewreporterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewreporterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewreporterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
