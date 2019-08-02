const countBs = str => {
  let count = 0;
  for (let i = 0; i < str.length; i++) {
    if (str[i] === 'B') {
      count++;
    }
  }
  return count;
};

const countChars = (str, char) => {
  let count = 0;
  for (let i = 0; i < str.length; i++) {
    if (str[i] === char) {
      count++;
    }
  }
  return count;
};

console.log(countBs('BBB'));
console.log(countBs('bBb'));
console.log(countBs('aaa'));

console.log(countChars('BBB', 'B'));
console.log(countChars('bBb', 'B'));
console.log(countChars('aaa', 'a'));
