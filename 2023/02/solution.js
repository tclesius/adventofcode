const fs = require('fs');

const data = fs.readFileSync('./input.txt', 'utf-8')
const gamesInput = data.split("\n")
  
  const possibleGames = [];
  const redCubes = 12;
  const greenCubes = 13;
  const blueCubes = 14;
  
  for (const game of gamesInput) {
    const cubes = game.match(/\d+ \w+/g);
    let possible = true;
  
    for (const cube of cubes) {
      const [quantity, color] = cube.split(' ');
      const num = parseInt(quantity);
      
      switch (color) {
        case 'red':
          if (num > redCubes) {
            possible = false;
          }
          break;
        case 'green':
          if (num > greenCubes) {
            possible = false;
          }
          break;
        case 'blue':
          if (num > blueCubes) {
            possible = false;
          }
          break;
      }
    }
  
    if (possible) {
      const gameId = game.match(/\d+/)[0];
      possibleGames.push(parseInt(gameId));
    }
  }
  
  const sumOfPossibleGames = possibleGames.reduce((acc, val) => acc + val, 0);
  console.log('Sum of IDs of possible games:', sumOfPossibleGames);