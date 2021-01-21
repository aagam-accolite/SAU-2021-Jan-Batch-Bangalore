import React, { useState } from "react";
import { Text, TextInput, View, AsyncStorage,Button,StyleSheet} from "react-native";
// import moment from "moment";

const AddNote = ({ navigation }) => {
    const [noteTitle, setNoteTitle] = useState("");
    const [noteContent, setNoteContent] = useState("");

    const submitNote = async () => {

        var newNote = {
            "title": noteTitle,
            "content": noteContent,
        }
        console.log(newNote);
        var notesList = await AsyncStorage.getItem("notesList");
        console.log("notesList", JSON.parse(notesList))
        notesList = JSON.parse(notesList);
        if (notesList === null) {
            notesList = [
                {
                    id: "1",
                    note: newNote,
                }
            ]
        } else {
            let noteId = notesList.length + 1;
            notesList.push(
                {
                    id: noteId,
                    note: newNote,
                }
            )
        }
        console.log(notesList);
        await AsyncStorage.setItem('notesList', JSON.stringify(notesList));
        var noteListFetched = await AsyncStorage.getItem('notesList');
        navigation.goBack();
    }
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

export default AddNote;


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
});
