def two_sum(arr, k):
    for i in range(len(arr)):
        for j in range(i+1, len(arr)):
            if (arr[i] + arr[j] == k):
                return True
    return False

def two_sum_one_pass(arr, k):
    for i in range(len(arr)):
        complement = k - arr[i]
        if complement in arr[i+1:]:
            return True

    return False

if __name__ == '__main__':
    arr = [1,2,3,4,5]
    assert(two_sum(arr, 9) == True)
    assert(two_sum(arr, 15) == False)
    assert(two_sum_one_pass(arr, 9) == True)
    assert(two_sum_one_pass(arr, 15) == False)