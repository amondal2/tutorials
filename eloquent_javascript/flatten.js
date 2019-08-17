// flatten an array of arrays at infinite depth
const flatten = arr => {
  let flat = [];
  for (val of arr) {
    if (Array.isArray(val)) {
      flat = flat.concat(flatten(val));
      console.log(flat);
    } else {
      flat.push(val);
    }
  }
  return flat;
};
flatten([1, 2, 3, [2, 3, [2, 3]]]);
