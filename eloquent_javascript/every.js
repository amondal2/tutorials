const everyLoop = (arr, test) => {
  let every = true;
  for (val of arr) {
    every = every && test(val);
  }
  return every;
};

const everySome = (arr, test) => {
  let every = arr.some(x => !test(x));
  return !every;
};

console.log(everyLoop([1, 2, 3], val => val === 1));
console.log(everyLoop([1, 1, 1], val => val === 1));

console.log(everySome([1, 2, 3], val => val === 1));
console.log(everySome([1, 1, 1], val => val === 1));
