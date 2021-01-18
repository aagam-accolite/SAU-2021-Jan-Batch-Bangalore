import React , {Component} from 'react';
import Todo from './component/Todo';
import Navbar from './component/Navbar'
import AddTodo from './component/AddTodo';

class App extends Component {
  
  // Initial State of Todo
  state = {
    todos : [
    ]
  }
  // Checkbox Todo Toggle 
  markedCompleted = (id) =>{
    this.setState( { todos : this.state.todos.map(todo => {
      if(todo.id === id)
      {
        todo.isCompleted = !todo.isCompleted;
      }
      return todo;
    })})
  }
  delTodo = (id) =>{
    this.setState ({ todos : [...this.state.todos.filter(todo => todo.id !== id )]})
  }
  componentDidUpdate(previousProps, previousState){
    var byDate = this.state.todos.slice(0);
    let sortedTodo = byDate.sort((a, b) =>
    a.date.split('/').reverse().join().localeCompare(b.date.split('/').reverse().join()));
    console.log(sortedTodo);
  }
  addTodo = (val) =>{
    const newTodo = {
      id : Math.random(),
      ...val,
      isCompleted :  true,
    }
    //console.log(newTodo);
    this.setState({ todos : [...this.state.todos, newTodo]})
  } 
  // Render Method
  render()
  {
    return(
        <div>
          <Navbar></Navbar><br/>
          <AddTodo addTodo = {this.addTodo}></AddTodo>
          <Todo todos = {this.state.todos}
            markedCompleted = {this.markedCompleted}
            delTodo = {this.delTodo}/>
        </div>
    );
  }
}

export default App;