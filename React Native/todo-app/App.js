import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { createStackNavigator } from '@react-navigation/stack';
import { NavigationContainer } from "@react-navigation/native";
import Login from './screen/Login';
import ViewTodo from './screen/ViewTodo/ViewTodo';
import Todo from './components/Todo';
const Stack = createStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
      <Stack.Screen name="login" component={Login} options={{ title: "Login Page" }} />
       <Stack.Screen name="view-todo" component={ViewTodo} options={{ title: "View Todo" }} /><Stack.Screen name="add-todo" component={Todo} options={{ title: "Add a new note" }} />
      </Stack.Navigator>
    </NavigationContainer> 
  );
}

