import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetleavesbydoctorComponent } from './getleavesbydoctor.component';

describe('GetleavesbydoctorComponent', () => {
  let component: GetleavesbydoctorComponent;
  let fixture: ComponentFixture<GetleavesbydoctorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetleavesbydoctorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetleavesbydoctorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
