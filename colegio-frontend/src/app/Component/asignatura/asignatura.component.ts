import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ApiService } from '../../Services/api.service';
import { FormularioAsignaturaComponent } from '../../Forms/formulario-asignatura/formulario-asignatura.component'; 
import { TableService } from './../../Services/table.service';
import { MatDialog } from '@angular/material/dialog';
import { FormsService } from '../../Services/forms.service';
import { TableTemplateComponent } from "../table-template/table-template.component";
import { lastValueFrom } from 'rxjs';

@Component({
  selector: 'app-asignatura',
  standalone: true,
  imports: [TableTemplateComponent],
  templateUrl: './asignatura.component.html',
  styleUrl: './asignatura.component.css'
})
export class AsignaturaComponent implements OnInit{
  column?:Object;
  displayedColumns: string[]=[]
  dataSource!: MatTableDataSource<any>; 
  acciones = 'acciones';
  Componenente?: String;
  titulo="Asignaturas";
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private Api: ApiService,public TableService: TableService,public dialog: MatDialog,public forms: FormsService){
    this.dataSource=new MatTableDataSource();
  }

  ngOnInit(): void {
      this.Getasignatura();
     
  }

  openModal() {
    const dialogRef = this.dialog.open(FormularioAsignaturaComponent);

  }

  async Getasignatura() {
    this.TableService.titleTabla = "Asignaturas";
    this.TableService.controlador = "Asignaturas";

    try {
      const res: any[] = await lastValueFrom(this.Api.get("asignaturas"));
      this.displayedColumns = Object.keys(res[0]);
      this.dataSource.data = res;
      this.TableService.dataSource = res;
      this.displayedColumns.push(this.acciones);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    } catch (error) {
      console.error("Error al obtener los datos de la tabla:", error);
    }
  }  
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}
