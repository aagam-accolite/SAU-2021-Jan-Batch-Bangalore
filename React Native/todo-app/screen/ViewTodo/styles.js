import { StyleSheet } from "react-native";
import { Dimensions } from 'react-native';

const styles = StyleSheet.create({
    container: {
        flex: 1,
        height: Dimensions.get("window").height,
        backgroundColor: '#f59842',
    },
    scrollView: {
        backgroundColor: '#f59842',
        marginBottom: Dimensions.get("window").height * 0.01
    },
    floatingButton: {
        flex: 1,
        justifyContent: 'flex-end'
    },
    noNotesContainer: {
        height: "100%",
        justifyContent: "center",
        alignSelf: "center",
    },
    noNotesText: {
        paddingTop: Dimensions.get("window").height*0.3,
        color: "white",
        fontSize:30,
        fontWeight: "bold",
        textAlign: "center"
    }
});

export default styles;