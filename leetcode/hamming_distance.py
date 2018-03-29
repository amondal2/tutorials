def calc_hamming_distance(x,y):
    binary_array = [bin(x)[2:], bin(y)[2:]]
    maxlen = len(max(binary_array, key=len))
    # need to left-pad the strings to be same length
    binary_array = [('0' * (maxlen - len(x))) + x for x in binary_array]
    distance = 0
    x_binary = binary_array[0]
    y_binary = binary_array[1]
    for i in range(len(x_binary)):
        if x_binary[i] != y_binary[i]:
            distance += 1
    return distance

print(calc_hamming_distance(4,1))