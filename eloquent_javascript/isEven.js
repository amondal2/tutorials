const isEven = n => {
  const abs = Math.abs(n);
  if (abs === 0) {
    return true;
  } else if (abs === 1) {
    return false;
  } else {
    return isEven(abs - 2);
  }
};

console.log(isEven(50));
console.log(isEven(75));
console.log(isEven(-1));
console.log(isEven(-2));
