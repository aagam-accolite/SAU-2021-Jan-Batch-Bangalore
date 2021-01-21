import React, { useEffect, useState } from "react";
import { View, ScrollView, Text ,AsyncStorage,Button} from "react-native";
import { useIsFocused } from "@react-navigation/native";
import TodoList from '../../components/TodoList';
import styles from './styles';

const ViewTodo = ({ navigation })=> {
    const isFocused = useIsFocused();
    const [notesList, setNotesList] = useState([]);
    const addNotes = () => {
      console.log("naviagiton of view notes");
      navigation.navigate('add-todo');
    }
    const fetchNotes = async () => {
        var notes = await AsyncStorage.getItem("notesList");
        //console.log(notes);
        if (notes !== null) {
            notes = JSON.parse(notes);
        }
        // console.log(notes);
        setNotesList(notes);

    }
    useEffect(() => {
        fetchNotes();
    }, [isFocused])
    return (
        <View style={styles.container}>
            {
                notesList ?
                    <ScrollView style={styles.scrollView}>
                        {
                            (notesList.map((el, idx) =>
                                <TodoList id={idx} noteData={el} navigation={navigation}/>
                            ))
                        }
                    </ScrollView>
                    :
                    <View styles={styles.noNotesContainer}>
                        <Text style={styles.noNotesSpacer}></Text>
                        <Text style={styles.noNotesText}>
                            No Notes
                            </Text>
                    </View>
            }
            <View>
              <Button  title="Add Todo" onPress={addNotes} ></Button>
            </View>
          </View>
    );
}

export default ViewTodo;