import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Tanu } from './tanu';

describe('Tanu', () => {
  let component: Tanu;
  let fixture: ComponentFixture<Tanu>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Tanu]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Tanu);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
