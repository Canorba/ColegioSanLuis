import { Routes } from '@angular/router';
import { HomeComponent } from './Component/home/home.component';
import { EstudianteComponent } from './Component/estudiante/estudiante.component';
import { AsignaturaComponent } from './Component/asignatura/asignatura.component';
import { LoginComponent } from './Component/login/login.component';
import { DocenteComponent } from './Component/docente/docente.component';

export const routes: Routes = [
{path:'', redirectTo: '/Home', pathMatch: 'full' } ,
{path:'Home',component: HomeComponent } ,
{path:'Estudiante',component: EstudianteComponent} ,
{path:'Docente',component: DocenteComponent},
{path:'Asignatura',component: AsignaturaComponent},
{path:'Login',component: LoginComponent}
];