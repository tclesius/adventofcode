const fs = require('fs');

function isNumeric(char) {
    return !isNaN(parseInt(char)) && isFinite(parseInt(char));
}

const data = fs.readFileSync('./example_2.txt', 'utf-8')
const lines = data.split("\n")

numbers = []
for(const line of lines){
    number = line.split('').filter(isNumeric)
    numbers.push(parseInt(number[0]+number[number.length-1]))
}
console.log(numbers.reduce((acc,cur) => acc + cur, 0));