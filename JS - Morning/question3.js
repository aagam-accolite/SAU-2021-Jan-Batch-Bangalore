/*
    Question 3 : Write a JavaScript program to check whether all the digits in a given number are the same or not.
*/

function allDigits(num) {
    var dig = num % 10;
    while (num != 0) {
        var digit = num % 10;
        if (digit != dig) {
            return false;
        }
        num = parseInt(num / 10);
    }
    return true;
}

console.log(allDigits(1211));