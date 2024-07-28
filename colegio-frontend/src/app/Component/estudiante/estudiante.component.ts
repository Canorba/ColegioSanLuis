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

  Componenente?: String;
  titulo="Estudiantes";
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private Api: ApiService,public TableService: TableService,public dialog: MatDialog,public forms: FormsService){
    this.dataSource=new MatTableDataSource();
  }

  ngOnInit(): void {
      this.Getpersona();
     
  }

  openModal() {
    const dialogRef = this.dialog.open(FormularioEstudianteComponent);

  }

  public async Getpersona(){
  this.TableService.titleTabla="Estudiantes";
  this.TableService.controlador = "Estudiantes";

     await this.Api.get("Estudiantes").then((res)=>{
     
      this.displayedColumns=Object.keys(res[0])
       
        this.dataSource.data=res
        this.TableService.dataSource=res;
    });
    this.dataSource.paginator=this.paginator;
    this.dataSource.sort=this.sort
  }
  
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}
