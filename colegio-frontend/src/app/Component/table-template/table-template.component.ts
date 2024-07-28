import { Dialog } from '@angular/cdk/dialog';
import { ApiService } from './../../Services/api.service';
import { TableService } from './../../Services/table.service';
import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Title } from '@angular/platform-browser';
import Swal from 'sweetalert2';
import { MatDialog } from '@angular/material/dialog';
import { FormsService } from '../../Services/forms.service';
import { HttpClient } from '@angular/common/http';
import { lastValueFrom, Observable } from 'rxjs';
import { FormularioAsignaturaComponent } from '../../Forms/formulario-asignatura/formulario-asignatura.component';
import { FormularioDocenteComponent } from '../../Forms/formulario-docente/formulario-docente.component';
import { FormularioEstudianteComponent } from '../../Forms/formulario-estudiante/formulario-estudiante.component';
import { MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-table-template',
  standalone: true,
  imports: [MatTableModule, MatInputModule, MatIconModule, CommonModule, MatPaginatorModule],
  templateUrl: './table-template.component.html',
  styleUrl: './table-template.component.css'
})
export class TableTemplateComponent implements OnInit{
  @Input() component:string = ''
  @Input() titulo:string = ''
  @Input() Componenente: string = ''
  column?:Object;
  displayedColumns: string[]=[]
  acciones: any = "Acciones"
  dataSource!: MatTableDataSource<any>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(public Api: ApiService, public TableService:TableService, public dialog: MatDialog, public forms:FormsService,private http: HttpClient ){
    this.dataSource=new MatTableDataSource();
  }

  ngOnInit(): void {
    
  this.datosTabla();
  }

  async datosTabla() {
    try {
      const res: any[] = await lastValueFrom(this.Api.get(this.Componenente));
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
 
  /*public async datosTabla(){
   
    await this.Api.get(this.TableService.controlador).then((res)=>{
      this.displayedColumns=Object.keys(res[0])
      this.dataSource.data=res
      this.TableService.dataSource=res
      this.displayedColumns.push(this.acciones) 
    });
    this.dataSource.paginator=this.paginator;
    this.dataSource.sort=this.sort
  }*/

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  
  eliminarRegistro(id: any): void {

    this.Api.delete(this.Componenente, id)
      .subscribe(
        () => {
          console.log('Registro eliminado exitosamente.');

          const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
              confirmButton: 'btn btn-success',
              cancelButton: 'btn btn-danger'
            },
            buttonsStyling: false
          })
          
          swalWithBootstrapButtons.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Yes, delete it!',
            cancelButtonText: 'No, cancel!',
            reverseButtons: true
          }).then((result) => {
            if (result.isConfirmed) {
              swalWithBootstrapButtons.fire(
                'Deleted!',
                'Your file has been deleted.',
                'success'
              )
            } else if (
              /* Read more about handling dismissals below */
              result.dismiss === Swal.DismissReason.cancel
            ) {
              swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your imaginary file is safe :)',
                'error'
              )
            }
          })
          
        },
        error => {
          console.error('Error al eliminar el registro:', error);
        
        }
      );
  } 

  edit(object:any){

 switch(this.Componenente){
      case "Estudiante":
        this.forms.object=object
          this.forms.componente.next("Estudiante")
          this.dialog.open(FormularioAsignaturaComponent);
        break;
        
      case "Docente":
          this.forms.object=object
              this.forms.componente.next("Docente")
            this.dialog.open( FormularioDocenteComponent);
            break;

        case "Asignatura":
              this.forms.object=object
              this.forms.componente.next("Asignatura")
              this.dialog.open( FormularioEstudianteComponent);
              break;
       }
    }
}
