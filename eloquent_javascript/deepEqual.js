const deepEqual = (first, second) => {
  if (first === null && second === null) {
    return true;
  }

  if (typeof first === 'object' && typeof second === 'object') {
    const firstKeys = Object.keys(first);
    const secondKeys = Object.keys(second);
    if (firstKeys.length !== secondKeys.length) return false;

    for (let i = 0; i < firstKeys.length; i++) {
      return deepEqual(first[firstKeys[i]], second[secondKeys[i]]);
    }
  }

  return first === second;
};

console.log(deepEqual(null, null));
console.log(deepEqual(1, 1));
console.log(deepEqual(1, 2));
console.log(deepEqual('hi', 'hi'));
console.log(deepEqual('hello', 'hi'));
console.log(deepEqual('hello', {}));
console.log('\n');
console.log(
  deepEqual(
    { hello: 'world', world: 'world' },
    { hello: 'world', world: 'world' },
  ),
);

console.log(
  deepEqual(
    { hello: 'world', world: 'world' },
    { hello: 'world', world: 'world2' },
  ),
);
