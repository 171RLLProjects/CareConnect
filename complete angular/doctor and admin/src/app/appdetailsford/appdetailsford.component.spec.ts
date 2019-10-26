import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppdetailsfordComponent } from './appdetailsford.component';

describe('AppdetailsfordComponent', () => {
  let component: AppdetailsfordComponent;
  let fixture: ComponentFixture<AppdetailsfordComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppdetailsfordComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppdetailsfordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
