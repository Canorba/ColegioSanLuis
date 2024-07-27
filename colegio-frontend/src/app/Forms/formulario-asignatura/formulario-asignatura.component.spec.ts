import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioAsignaturaComponent } from './formulario-asignatura.component';

describe('FormularioAsignaturaComponent', () => {
  let component: FormularioAsignaturaComponent;
  let fixture: ComponentFixture<FormularioAsignaturaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormularioAsignaturaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormularioAsignaturaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
