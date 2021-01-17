import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SessionModuleComponent } from './session-module.component';

describe('SessionModuleComponent', () => {
  let component: SessionModuleComponent;
  let fixture: ComponentFixture<SessionModuleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SessionModuleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SessionModuleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
