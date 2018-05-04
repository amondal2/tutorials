# generate random data for response generation
import random
def generate_data():
	data = []
	for i in range(1,10):
		# simulate lists, strings, and numbers
		data_type = random.randint(1,3)
		if data_type == 1:
			random_string = ''.join(random.choice('0123456789ABCDEF') for i in range(20))
			data.append(["1,%i" % i, random_string])
		elif data_type == 2:
			number_choices = random.randint(1,10)
			random_list = random.sample(range(1,100), number_choices)
			data.append(["1,%i" % i, random_list])
		else:
			random_number = random.uniform(-100,100)
			data.append(["1,%i" % i, random_number])
	return data

if __name__ == '__main__':
	for i in range(0,5):
		print(generate_data())
			
