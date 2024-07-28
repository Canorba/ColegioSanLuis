import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { FormsService } from '../../Services/forms.service';
import { ApiService } from '../../Services/api.service';
import Swal from 'sweetalert2';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field'; // Asegúrate de importar el módulo
import { MatInputModule } from '@angular/material/input'; // También necesitas importar MatInputModule
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-formulario-asignatura',
  standalone: true,
  imports: [MatCardModule, MatFormFieldModule, MatInputModule, ReactiveFormsModule, CommonModule],
  templateUrl: './formulario-asignatura.component.html',
  styleUrl: './formulario-asignatura.component.css'
})
export class FormularioAsignaturaComponent implements OnInit{
  
  constructor(private fb: FormBuilder, public forms: FormsService , public Api:ApiService) {}
  hasUnitNumber = false; 
  addressForm!: FormGroup;
 
   
  ngOnInit(): void {
    this.addressForm = this.fb.group({
      id: [null, Validators.required],
      nombre: [null, Validators.required],
      docenteId: [null, Validators.required] // Asegúrate de que el nombre coincida con el payload
    });

    this.forms.componente.subscribe((res) => {
      if (res === "Asignaturas") {
        if (this.forms.object && this.forms.object.id) {
          this.addressForm.setValue({
            id: this.forms.object.id,
            nombre: this.forms.object.nombre,
            docenteId: this.forms.object.docenteId // Asegúrate de que el nombre coincida
          });
        }
      }
    });
  }

  async onSubmit(): Promise<void> {
    if (this.addressForm.invalid) {
      console.error('Formulario inválido');
      return;
    }

    const formValue = this.addressForm.value;
    const payload = {
      nombre: formValue.nombre,
      docente: {
        id: formValue.docenteId
      }
    };

    try {
      await this.Api.put('asignaturas', payload, formValue.id);
      console.log('Datos guardados exitosamente.');
      Swal.fire({
        icon: 'success',
        title: 'Éxito',
        text: 'Los cambios se han guardado exitosamente.',
        confirmButtonText: 'Aceptar'
      });
    } catch (error) {
      console.error('Error al guardar los datos:', error);
      Swal.fire({
        icon: 'error',
        title: 'Error',
        text: 'Se produjo un error al guardar los cambios.',
        confirmButtonText: 'Aceptar'
      });
    }
  
    /*try {
      await this.Api.put('asignaturas', payload, formValue.id); // Envía el ID con el payload
      
    } catch (error) {
      console.error('Error al guardar los datos:', error);
    }*/
  }
}