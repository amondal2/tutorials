# print matrix in spiral form

x = [[1,2,3,4], [4,5,6,6,4], [7,8,9,10]]
all_numbers = []
for i in range(len(x)):
	if (i % 2 == 0):
		for j in x[i]:
			all_numbers.append(j)
	else:
		for k in reversed(x[i]):
			all_numbers.append(k)

print(all_numbers)
		
