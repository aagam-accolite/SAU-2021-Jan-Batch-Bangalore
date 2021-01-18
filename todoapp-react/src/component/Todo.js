import React,{Component} from 'react';
import Todoitem from './Todoitem';

class Todo extends Component{
    render(){
        return this.props.todos.map((todo) => (
            <Todoitem key = {todo.id} todo = {todo} 
            markedCompleted= {this.props.markedCompleted}
            delTodo = {this.props.delTodo}/>
          ));
    }
}

export default Todo;