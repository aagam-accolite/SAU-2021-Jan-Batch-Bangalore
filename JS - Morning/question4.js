/*
    Question 4 : Write a JavaScript program to compute the sum of all digits that occur in a given string
*/ 

function sumOfDigits(num)
{
    num = parseInt(num);
    var sum = 0;
    while(num!=0)
    {
        var digit = num % 10;
        //console.log('Digit ' + digit);
        sum = sum + digit;
        //console.log('Sum ' + sum);
        num = parseInt(num / 10);
    }
    return sum;
}

console.log(sumOfDigits("123"));