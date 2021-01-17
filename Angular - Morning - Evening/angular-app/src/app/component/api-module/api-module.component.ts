import { ServiceService } from './../../service/service.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-api-module',
  templateUrl: './api-module.component.html',
  styleUrls: ['./api-module.component.scss']
})
export class ApiModuleComponent implements OnInit {

  todos: any;
  singleTodo: any;
  displayTodos: boolean;
  
  constructor(private session:ServiceService) {
    this.displayTodos = true;
   }

  ngOnInit(): void {
    this.session.getData().subscribe((item) => {
      this.todos = item;
    });
  }
  
  setdisplayTodos() {
    this.displayTodos = true;
    this.singleTodo = [];
  }
 
  getApiValue(id: string) {
    this.session.getDataByID(parseInt(id)).subscribe((item) => {
      this.singleTodo = [item];
      this.displayTodos = false;
    });
  }
 

}
