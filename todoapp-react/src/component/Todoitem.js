import React, { Component } from 'react';
import './Todoitem.css';

class Todoitem extends Component {
    getStyle = () =>{
        if(!this.props.todo.isCompleted){
            return {
                textDecoration : 'line-through'
              }
        }
        else{
            return {
                textDecoration : 'none'
              }
        }
    }
    render() {
        const { id,title,description,date } = this.props.todo;
        return (
            <div style = {this.getStyle()}>
                
                <p className='para'>
                <input type='checkbox' onChange={this.props.markedCompleted.bind(this,id)}></input>
                   Title :  { title } <br></br>
                   Description : { description } <br></br>
                   Date : { date } 
                <button className='btn' onClick = {this.props.delTodo.bind(this,id)}> Delete </button>
                </p>
            </div>
        );
    }
}

export default Todoitem;