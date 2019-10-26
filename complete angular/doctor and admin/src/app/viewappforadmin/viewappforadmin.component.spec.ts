import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewappforadminComponent } from './viewappforadmin.component';

describe('ViewappforadminComponent', () => {
  let component: ViewappforadminComponent;
  let fixture: ComponentFixture<ViewappforadminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewappforadminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewappforadminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
