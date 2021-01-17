import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) { }
  
  getDataByID(id: string | number) {
    const url = 'https://jsonplaceholder.typicode.com/todos/' + id;
    return this.http.get(url);
  }
  
  getData() {
    const url = 'https://jsonplaceholder.typicode.com/todos/';
    return this.http.get(url);
  }
}
