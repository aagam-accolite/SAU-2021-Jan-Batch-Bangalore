import React from "react";
import { TouchableOpacity, View, Text ,AsyncStorage,StyleSheet,Dimensions ,Button} from "react-native";

const Todo = ({ noteData, navigation })=> {

    const deleteCard = async (id) => {
        console.log("delete card", id);
        let currentList = JSON.parse(await AsyncStorage.getItem("notesList"));
        console.log("the current list is", currentList);

        for (var i in currentList) {
            console.log(i, id, currentList[i].id)
            if (currentList[i].id == id) {
                currentList.splice(parseInt(i), 1);

            }
        }
        console.log("after deleting", currentList)
        await AsyncStorage.setItem("notesList", JSON.stringify(currentList));
        console.log("done");
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
                {console.log("inside note card componet", noteData.note.title)}

                <Text style={styles.noteId}> {noteData.id} </Text>
                <Text style={styles.noteTitle}> Title : {noteData.note.title} </Text>
                <Text style={styles.noteDate}> Description :{noteData.note.date} </Text>
                <TouchableOpacity onPress={() => deleteCard(noteData.id)} style={styles.noteDelete}>
                    <Text style={{ color: "red", fontWeight: "bold" }}>Delete</Text>
                </TouchableOpacity>
            </View>
            <Text style={styles.contentContainer}> {noteData.note.content} </Text>

        </View>
    );
}


export default Todo;


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
    },
    noteTitle: {
        width: '50%',
        fontSize: 14,
        color: "black",
        fontWeight: "500",
        padding: 5,
    },
    noteDate: {
        width: '50%',
        fontSize: 12,
        color: "black",
        fontWeight: "100",

    },
    noteDelete:{
        width: '20%',
        fontSize: 12,
        color: "black",
        fontWeight: "100",
        padding: 5,
    }
});
