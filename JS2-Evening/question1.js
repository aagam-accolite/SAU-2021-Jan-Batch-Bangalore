class inputForm {
    constructor(inputField) {
        this.inputField = inputField;
    }
    calculateLength() {
        console.log('Input Field Length is ' + this.inputField.length);
        return this.inputField.length;
    }
    convertUpperCase() {
        console.log('Input Field to Uppercase is ' + this.inputField.toUpperCase);
        return this.inputField.toUpperCase();
    }
    convertLowerCase() {
        console.log('Input Field to Lowercase is ' + this.inputField.toLowerCase);
        return this.inputField.toLowerCase();
    }
    seperateAlpha() {
        let vowels = "";
        let consonants = "";
        for (let i = 0; i < this.inputField.length; i++) {
            if (this.inputField.charAt(i) === 'A' || this.inputField.charAt(i) === 'a' ||
                this.inputField.charAt(i) === 'E' || this.inputField.charAt(i) === 'e' ||
                this.inputField.charAt(i) === 'I' || this.inputField.charAt(i) === 'i' ||
                this.inputField.charAt(i) === 'O' || this.inputField.charAt(i) === 'o' ||
                this.inputField.charAt(i) === 'U' || this.inputField.charAt(i) === 'u') {
                vowels += this.inputField.charAt(i);
            }
            else {
                consonants += this.inputField.charAt(i);
            }
        }
        console.log("Vovels are : " + vowels + " Consonents are : " + consonants);
        return " <p> Vowels : <h3> " + vowels + "</h3>  Consonants  : <h3>" + consonants + "</h3> </p>"
    }
    isNumPresent() {
        for (let i = 0; i < this.inputField.length; i++) {
            if(this.inputField.charAt(i) === ' ')
            {
                continue;
            }
            if (!isNaN(this.inputField.charAt(i))) {
                console.log('Error : Input Field has Number Present in it');
                return true;
            }
        }
        console.log('Input Field has NO number present ');
        return false;
    }
}

function callForm(event) {
    event.preventDefault();
    var inputValue = document.forms["myForm"]["inputfield"].value;;
    console.log(inputValue);
    let inputObject = new inputForm(inputValue);
    document.getElementById("lengthStr").innerHTML = inputObject.calculateLength();
    document.getElementById("Strupr").innerHTML = inputObject.convertUpperCase();
    document.getElementById("Strlcr").innerHTML = inputObject.convertLowerCase();
    document.getElementById("seperateAlphabets").innerHTML = inputObject.seperateAlpha();
    if (inputObject.isNumPresent()) {
        document.getElementById("isNumberPresent").innerHTML = "Error :  Number is present in this Input Field";
    }
    else {
        document.getElementById("isNumberPresent").innerHTML = "No Error";
    }
}