import React, { Component } from 'react';

class AddTodo extends Component {
    state = {
        title: '',
        description : '',
        date : ''
    }
    setTitle = (e) => {
        this.setState({ title: e.target.value })
    }
    setDescription = (e) => {
        this.setState({ description: e.target.value })
    }
    setDate = (e) => {
        this.setState({ date: e.target.value })
    }
    onSubmit = (e) =>{
        e.preventDefault();
        
        //console.log(this.state);
        this.props.addTodo(this.state);
        this.setState({ title : '', description : '',date: ''});
    }
    render() {
        return (
            <div>
                <form onSubmit={this.onSubmit} style={{marginLeft:20}}>
                    <input
                        type='text'
                        placeholder='Enter Todo Title'
                        value={this.state.title}
                        onChange={this.setTitle}
                    ></input>
                    <input
                        type='text'
                        placeholder='Enter Todo Description'
                        value={this.state.description}
                        onChange={this.setDescription}
                    ></input>
                    <input
                        type='Date'
                        placeholder='Enter Todo Date'
                        value={this.state.date}
                        onChange={this.setDate}
                    ></input>
                    <input type='submit' value='Add Todo'></input>
                </form>
            </div>
        );
    }
}

export default AddTodo;