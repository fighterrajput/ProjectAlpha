import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InstalistComponent } from './instalist.component';

describe('InstalistComponent', () => {
  let component: InstalistComponent;
  let fixture: ComponentFixture<InstalistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InstalistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InstalistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
