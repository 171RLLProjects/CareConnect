import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SuggestdoctorsComponent } from './suggestdoctors.component';

describe('SuggestdoctorsComponent', () => {
  let component: SuggestdoctorsComponent;
  let fixture: ComponentFixture<SuggestdoctorsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SuggestdoctorsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SuggestdoctorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
