const loop = (value, test, update, execute) => {
  if (!test(value)) return; // stop
  execute(value);
  return loop(update(value), test, update, execute);
};
