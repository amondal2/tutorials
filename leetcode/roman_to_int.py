roman_map = {
	"I" : 1,
	"V" : 5,
	"X" : 10,
	"L" : 50,
	"C" : 100,
	"D" : 500,
	"M" : 1000
}


def roman_to_int(roman):
	total = 0
	i = 0
	while i < len(roman):
		if i == len(roman)-1:
			total += roman_map[roman[i]]
			return total
		elif roman_map[roman[i+1]] > roman_map[roman[i]]:
			total += (roman_map[roman[i+1]] - roman_map[roman[i]])
			i = i+1
		else:
			total += roman_map[roman[i]]
		i = i+1
	return total

	
assert(roman_to_int("MCMXCVI") == 1996)
assert(roman_to_int("XVII") == 17)
assert(roman_to_int("DLCXVI") == 566)
