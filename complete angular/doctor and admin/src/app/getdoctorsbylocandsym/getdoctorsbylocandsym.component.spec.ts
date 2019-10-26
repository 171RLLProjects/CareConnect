import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetdoctorsbylocandsymComponent } from './getdoctorsbylocandsym.component';

describe('GetdoctorsbylocandsymComponent', () => {
  let component: GetdoctorsbylocandsymComponent;
  let fixture: ComponentFixture<GetdoctorsbylocandsymComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetdoctorsbylocandsymComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetdoctorsbylocandsymComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
