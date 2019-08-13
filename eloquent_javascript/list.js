const arrayToList = arr => {
  const list = {};
  for (let i = 0; i < arr.length; i++) {
    list.value = arr.splice(0, 1)[0];
    list.rest = arr.length ? arrayToList(arr) : null;
  }
  return list;
};

const listToArray = list => {
  let arr = [];
  arr.push(list.value);
  if (list.rest) {
    const value = listToArray(list.rest);
    arr = [...arr, value];
  }
  return arr.flat(Infinity);
};

console.log(arrayToList([1, 2, 3]));
console.log(
  listToArray({
    value: 1,
    rest: {
      value: 1,
      rest: {
        value: 2,
        rest: null,
      },
    },
  }),
);
