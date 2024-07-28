import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ApiService } from '../../Services/api.service';
import { FormularioEstudianteComponent } from '../../Forms/formulario-estudiante/formulario-estudiante.component';
import { TableService } from './../../Services/table.service';
import { MatDialog } from '@angular/material/dialog';
import { FormsService } from '../../Services/forms.service';
import { TableTemplateComponent } from "../table-template/table-template.component";
import { lastValueFrom } from 'rxjs';

@Component({
  selector: 'app-estudiante',
  standalone: true,
  imports: [TableTemplateComponent],
  templateUrl: './estudiante.component.html',
  styleUrl: './estudiante.component.css'
})
export class EstudianteComponent implements OnInit{

  column?:Object;
  displayedColumns: string[]=[]
  dataSource!: MatTableDataSource<any>; 
  acciones = 'acciones';
  Componenente?: String;
  titulo="Estudiantes";
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private Api: ApiService,public tableService: TableService,public dialog: MatDialog,public forms: FormsService){
    this.dataSource=new MatTableDataSource();
  }

  ngOnInit(): void {
      this.Getestudiantes();
     
  }

  openModal() {
    const dialogRef = this.dialog.open(FormularioEstudianteComponent);

  }

  async Getestudiantes() {
    this.tableService.titleTabla = "Estudiantes";
    this.tableService.controlador = "Estudiantes";

    try {
      const res: any[] = await lastValueFrom(this.Api.get("estudiantes"));
      this.displayedColumns = Object.keys(res[0]);
      this.dataSource.data = res;
      this.tableService.dataSource = res;
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
