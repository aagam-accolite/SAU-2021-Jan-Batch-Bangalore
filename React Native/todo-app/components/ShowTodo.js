import React from "react";
import { TouchableOpacity, View, Text ,AsyncStorage ,StyleSheet ,Dimensions } from "react-native";


const ShowTodo = ({ noteData, navigation }) => {

    const deleteCard = async (id) => {
        let currentList = JSON.parse(await AsyncStorage.getItem("notesList"));

        for (var i in currentList) {
            console.log(i, id, currentList[i].id)
            if (currentList[i].id == id) {
                currentList.splice(parseInt(i), 1);

            }
        }
        await AsyncStorage.setItem("notesList", JSON.stringify(currentList));
        currentList = JSON.parse(await AsyncStorage.getItem("notesList"));

        console.log(currentList)
        navigation.reset({
            index: 0,
            routes: [{ name: "view-notes" }],
        });
    }

    return (
        <View>
            <View style={styles.detailsContainer}>
                <Text style={styles.noteId}> {noteData.id} </Text>
                <Text style={styles.noteTitle}> {noteData.note.title} </Text>
                <Text style={styles.noteDate}> {noteData.note.date} </Text>
                <TouchableOpacity onPress={() => deleteCard(noteData.id)} style={styles.noteDelete}>
                    <Text>Delete</Text>
                </TouchableOpacity>
            </View>
            <Text style={styles.contentContainer}> {noteData.note.content} </Text>
        </View>
    );
}

export default ShowTodo;


const styles = StyleSheet.create({
    detailsContainer: {
        flex: 1,
        flexDirection: 'row',
        flexWrap: 'wrap',
    },
    contentContainer: {
        flex: 1,
        flexWrap: 'wrap',
        borderBottomColor: "black",
        borderBottomWidth: 1,
        paddingLeft: Dimensions.get("window").width * 0.1,
        paddingRight: Dimensions.get("window").width * 0.03,

    },
    noteId: {
        width: '10%',
        fontSize: 16,
        color: "black",
        fontWeight: "700",
        padding: 5,
        borderRightColor: "red",
        borderRightWidth: 0.5,
        borderBottomColor: "red",
        borderBottomWidth: 0.5
    },
    noteTitle: {
        width: '60%',
        fontSize: 14,
        color: "black",
        fontWeight: "500",
        padding: 5,
        borderRightColor: "red",
        borderRightWidth: 0.5
    },
    noteDate: {
        width: '20%',
        fontSize: 12,
        color: "black",
        fontWeight: "100",
        padding: 5,
        borderBottomColor: "red",
        borderBottomWidth: 0.5
    },
    noteDelete:{
        width: '5%',
        fontSize: 12,
        color: "black",
        fontWeight: "100",
        padding: 5,
        borderBottomColor: "red",
        borderBottomWidth: 0.5
    }
});
