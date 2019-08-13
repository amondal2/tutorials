const range = (a, b, step = 1) => {
  const interval = [];
  for (let i = a; i <= b; i = i + step) {
    interval.push(i);
  }
  return interval;
};

const sum = arr => {
  return arr.reduce((val, acc) => val + acc, 0);
};

console.log(range(1, 10, 2));
console.log(range(1, 10));
console.log(sum(range(1, 10)));
