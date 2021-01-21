import React, { useEffect, useState } from "react";
import { View, ScrollView, Text, AsyncStorage, StyleSheet, Dimensions, Button } from "react-native";
import { useIsFocused } from "@react-navigation/native";
import { ShowTodo } from "../components/ShowTodo";

const ViewTodo = ({ navigation }) => {
    const isFocused = useIsFocused();
    const [notesList, setNotesList] = useState([]);
    const addNotes = () => {
        console.log("naviagiton of view notes");
        navigation.navigate("add-notes");
    }
    const fetchNotes = async () => {
        var notes = await AsyncStorage.getItem("notesList");
        console.log(notes);
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
                                <ShowTodo id={idx} noteData={el} navigation={navigation} />
                            ))
                        }
                    </ScrollView>:
                    <View styles={styles.noNotesContainer}>
                        <Text style={styles.noNotesText}>
                            No Notes Present
                            </Text>
                    </View>
            }

            <View style={styles.floatingButton}>
                <View>
                    <Button action={addNotes} />
                </View>
                <View>
                    {}
                </View>
            </View>
        </View>
    );
}

export default ViewTodo;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        height: Dimensions.get("window").height,
    },
    scrollView: {
        marginBottom: Dimensions.get("window").height * 0.01
    },
    floatingButton: {
        flex: 1,
        justifyContent: 'flex-end'
    },
    btn: {
        position: 'absolute',
        width: 50,
        height: 50,
        alignItems: 'center',
        justifyContent: 'center',
        right: 30,
        bottom: 30,
    },
    btnText: {
        color: "blue",
        fontWeight: "bold",
        textAlign: "center"
    },
    FloatingButtonStyle: {
        resizeMode: 'contain',
        width: 50,
        height: 50,
    },
    noNotesContainer: {
        height: "100%",
        justifyContent: "center",
        alignSelf: "center",
    },
    noNotesText: {
        paddingTop: Dimensions.get("window").height * 0.3,
        color: "blue",
        fontSize: 30,
        fontWeight: "bold",
        textAlign: "center"
    }
});
