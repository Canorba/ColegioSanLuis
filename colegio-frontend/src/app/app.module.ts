import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatNativeDateModule} from '@angular/material/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MenuLateralComponent } from './Component/menu-lateral/menu-lateral.component';
import { AsignaturaComponent } from './Component/asignatura/asignatura.component'; 
import { DocenteComponent } from './Component/docente/docente.component';
import { EstudianteComponent } from './Component/estudiante/estudiante.component';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatCardModule } from '@angular/material/card';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {MatTableModule} from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatPaginatorModule } from '@angular/material/paginator';
import { TableTemplateComponent } from './Component/table-template/table-template.component'; 
import {MatDialogModule} from '@angular/material/dialog';
import { FormularioAsignaturaComponent } from './Forms/formulario-asignatura/formulario-asignatura.component'; 
import { FormularioDocenteComponent } from './Forms/formulario-docente/formulario-docente.component'; 
import { FormularioEstudianteComponent } from './Forms/formulario-estudiante/formulario-estudiante.component'; 
import {MatDatepickerModule} from '@angular/material/datepicker';
import { LoginComponent } from './Component/login/login.component'; 
import { routes } from './app.routes';
import { MatSortModule } from '@angular/material/sort';

NgModule({
  declarations: [
    AppComponent,
    MenuLateralComponent,
    AsignaturaComponent,
    DocenteComponent,
    EstudianteComponent,
    LoginComponent,
    FormularioAsignaturaComponent,
    FormularioDocenteComponent,
    FormularioEstudianteComponent,
    TableTemplateComponent
],
  imports: [
    BrowserModule,
    routes,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatSortModule,
    routes,
    MatInputModule,
    MatSelectModule,
    MatRadioModule,
    MatCardModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatTableModule,
    MatFormFieldModule,
    MatPaginatorModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatDialogModule,
    CommonModule
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }