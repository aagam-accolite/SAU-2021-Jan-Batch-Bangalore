import React, { useEffect,useState } from 'react';
import { StyleSheet, Text, View, TextInput, Button, Image, ScrollView , AsyncStorage} from 'react-native';
//import AsyncStorage from '@react-native';

const Login = ({navigation}) => {

    const [userName, setUserName] = useState("");

  const loginBtn = async() => {
        
        console.log("inside navigation");
        await AsyncStorage.setItem("userName", userName);
        console.log(userName);
        console.log("async" + await AsyncStorage.getItem("username"));
        navigation.reset({
            index: 0,
            routes: [{ name: "view-todo" }],
        });
        return;
    }
   

    const checkAuth = async () => {
        const currentUser = await AsyncStorage.getItem("userName");
        if (currentUser) {
            navigation.reset({
                index: 0,
                routes: [{ name: "view-todo" }],
            });
        }
        return;
    }

   useEffect(() => {
        checkAuth();
    }, []);


    return (
        <View style={styles.container}>
            <Image source={
                { uri: 'https://img.freepik.com/free-vector/people-making-list-illustration_53876-64623.jpg?size=626&ext=jpg' }}
                style={styles.logoImg}></Image>
            <Text style={styles.welcome}>Todo Application - Login</Text>
            <TextInput style={styles.input} placeholder='User Name' onChangeText = {(userName) => setUserName(userName)}></TextInput>
            <TextInput style={styles.input} placeholder='Password' onChangeText = {(password) => setUserName(password)}></TextInput>
            <Button style={styles.btn} title="Login" onPress={loginBtn} />
        </View>
    );
}

export default Login;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#f59842',
    },
    welcome: {
        fontSize: 30,
        textAlign: 'center',
        color: '#FFF',
        fontFamily: 'Roboto',
    },
    input: {
        width: '90%',
        backgroundColor: '#FFF',
        padding: 15,
        margin: 10,
        borderRadius: 20
    },
    logoImg: {
        width: '80%',
        height: '27%',
        resizeMode: 'cover',
        borderRadius: 20
    },
});