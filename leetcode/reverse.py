def reverse(x):
	if x < 0:
		return_val = int(str(x)[1:][::-1]) * -1
	else:
		return_val = int(str(x)[::-1])
	if abs(return_val) > 2**31 - 1:
		return 0
	
	return return_val

assert(reverse(123) == 321)
assert(reverse(-345) == -543)
assert(reverse(99999999999) == 0)
