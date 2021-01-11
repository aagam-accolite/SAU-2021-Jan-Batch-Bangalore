/*
    Question 2 : Write a JavaScript program to change the capitalization (case) of all letters in a given string.
*/

function capitalization( str )
{
    let string = "";
    function isUpperCase(str) {
        return str === str.toUpperCase();
    }
    function isLowerCase(str) {
        return str === str.toLowerCase();
    }
    for(let i=0;i<str.length;i++)
    {
        if(isUpperCase(str[i]))
        {   
          string += str[i].toLowerCase();
        }
        if(isLowerCase(str[i]))
        {
            string += str[i].toUpperCase();  
        }
    }
    return string;
}

console.log(capitalization('Aagam'));