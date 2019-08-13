const reverseArray = arr => {
  const newArr = [];
  for (let i = arr.length; i > 0; i--) {
    newArr.push(i);
  }
  return newArr;
};

const reverseInPlace = arr => {
  for (let i = 0; i <= Math.floor((arr.length - 1) / 2); i++) {
    let el = arr[i];
    arr[i] = arr[arr.length - 1 - i];
    arr[arr.length - 1 - i] = el;
  }
  return arr;
};

console.log(reverseInPlace([1, 2, 3]));
