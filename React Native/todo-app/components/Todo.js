import React from 'react';
import { StyleSheet, Text, View, TextInput, Button, Image, ScrollView } from 'react-native';

const Todo = ({navigation}) => {
    return (
        <View style={styles.container}>
            <Text style={styles.mainText}>Add Todo</Text>
            <Text style={styles.labelText}>Todo Title</Text>
            <TextInput style={styles.inputTit} placeholder='Enter Todo Title'></TextInput>
            <Text style={styles.labelText}>Todo Description</Text>
            <TextInput multiline style={styles.inputDesc} placeholder='Enter Todo Description'></TextInput>
           <Button title="Submit"></Button>
        </View>
    );
}
export default Todo;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#1e90ff',
        marginTop: 24,
    },
    mainText: {
        fontSize: 30,
        textAlign: 'center',
        margin: 40,
        color: '#FFF',
        fontWeight:'bold',
        textDecorationLine : 'underline',
        fontFamily: 'Roboto',
    },
    labelText: {
        fontSize: 24,
        textAlign: 'left',
        marginLeft: 15,
        color: '#FFF',
        fontFamily: 'Roboto',
    },
    inputTit: {
        width: '90%',
        backgroundColor: '#FFF',
        padding: 15,
        margin: 15,
        borderRadius:20
    },
    inputDesc: {
        width: '90%',
        height: '30%',
        backgroundColor: '#FFF',
        padding: 15,
        margin: 15,
        borderRadius:20
    },
    btnContainer:{
        marginTop:15,
        justifyContent: 'center',
        alignItems: 'center',
    },
    usrBtn: {
        backgroundColor: '#FFD700',
        padding: 20,
        width: 170,
        borderRadius: 30
    },
    btnTxt: {
        fontSize: 16,
        textAlign: 'center'
    },
});