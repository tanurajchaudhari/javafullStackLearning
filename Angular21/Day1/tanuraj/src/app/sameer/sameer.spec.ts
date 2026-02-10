import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Sameer } from './sameer';

describe('Sameer', () => {
  let component: Sameer;
  let fixture: ComponentFixture<Sameer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Sameer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Sameer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
