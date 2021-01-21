import React from "react";
import { Text, TextInput, View } from "react-native";
import { AddNotes } from "../components/AddNote";
const Add = ({ navigation }) => {
    return (
        <View>
            <AddNotes navigation={navigation} />
        </View>
    );
}

export default Add;