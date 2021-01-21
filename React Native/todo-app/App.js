import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { createStackNavigator } from '@react-navigation/stack';
import { NavigationContainer } from "@react-navigation/native";
import Login from './screens/Login';
import Add from './screens/Add';
import ViewTodo from './screens/ViewTodo';

const Stack = createStackNavigator();

export default function App() {
  return (
   <NavigationContainer>
      <Stack.Navigator>
      <Stack.Screen name="login" component={Login} options={{ title: "Login Page" }} />
        <Stack.Screen name="view-notes" component={ViewTodo} options={{ title: "Notes made by you" }} />
        <Stack.Screen name="add-notes" component={Add} options={{ title: "Add a new note" }} />
      </Stack.Navigator>
    </NavigationContainer> 
  );
}
