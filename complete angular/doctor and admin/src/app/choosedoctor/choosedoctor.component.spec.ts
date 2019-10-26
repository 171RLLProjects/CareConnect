import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChoosedoctorComponent } from './choosedoctor.component';

describe('ChoosedoctorComponent', () => {
  let component: ChoosedoctorComponent;
  let fixture: ComponentFixture<ChoosedoctorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChoosedoctorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChoosedoctorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
