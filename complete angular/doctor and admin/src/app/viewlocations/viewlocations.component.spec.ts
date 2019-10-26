import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewlocationsComponent } from './viewlocations.component';

describe('ViewlocationsComponent', () => {
  let component: ViewlocationsComponent;
  let fixture: ComponentFixture<ViewlocationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewlocationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewlocationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
