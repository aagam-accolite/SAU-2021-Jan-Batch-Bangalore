/*
    Question 1 : Write a JavaScript program to find all distinct prime factors of a given integer.
*/

function primeFactor(num) {
    
    function isPrime(num) {
        for (let i = 2; i <= Math.sqrt(num); i++) 
        {
            if (num % i === 0) 
            {
                return false;
            }
        }
        return true;
    }
    const res = []
    for (let i = 2; i <= num; i++) {
        while (isPrime(i) && num % i === 0) 
        {
            if (!res.includes(i)) 
            {
                res.push(i);
            }
            num /= i;
        }
    }
    return res;
}

console.log(primeFactor(105));
