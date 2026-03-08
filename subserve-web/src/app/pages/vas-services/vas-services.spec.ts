import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VasServices } from './vas-services';

describe('VasServices', () => {
  let component: VasServices;
  let fixture: ComponentFixture<VasServices>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VasServices],
    }).compileComponents();

    fixture = TestBed.createComponent(VasServices);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
