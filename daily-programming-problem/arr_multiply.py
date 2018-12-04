def skip_index(arr, i):
    total_val = 1
    for j,val in enumerate(arr):
        if i == j:
            continue
        else:
            total_val = total_val * val
    return total_val

def multiply_array(arr):
    new_arr = []
    for i,_ in enumerate(arr):
        new_arr.append(skip_index(arr, i))
    return new_arr


if __name__ == '__main__':
    assert(multiply_array([1,2,3,4,5]) == [120, 60, 40, 30, 24])
    assert(multiply_array([3,2,1]) == [2,3,6])
