import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { lastValueFrom } from 'rxjs/internal/lastValueFrom';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private url = "http://localhost:8080/";

  constructor(private http: HttpClient) { }

  public get(controlador: string): Observable<any> {
    return this.http.get<any>(this.url + controlador);
  }

  /*public async get(controlador: string) {
    var response: any
    await this.http.get(this.url + controlador).toPromise().then(res => {
      response = res
      console.log(response);
    });
    return response
  }*/
  

  public async getById(controlador: string, id:any) {
    var response: any
    await this.http.get(this.url + controlador+"/"+ id).subscribe(res => {
      response = res
    });
    
    return response
  }

  public async post(controlador: string, body:string) {
    var response: any
    await this.http.post(this.url + controlador,body).subscribe(res => {
      response = res
    });
    return response
  }

  // public async put(controlador: string, body:any, id:any) {
  //   var response: any
  //   await this.http.put(this.url + controlador+"/"+ id, body).subscribe(res => {
  //     response = res
  //     console.log("res"+response);
  //   });
  //   return response
    
    
  // }
  public async put(controlador: string, body: any, id: any) {
    try {
      
      const response = await this.http.put(this.url + controlador + "/" + id, body).toPromise();
      
      return response;
    } catch (error) {
      console.error("Error al realizar la solicitud PUT:", error);
      throw error;
    }
  }

  delete(controlador: string, id: any): Observable<any> {
    return this.http.delete(`${this.url}${controlador}/${id}`);
  }
}
