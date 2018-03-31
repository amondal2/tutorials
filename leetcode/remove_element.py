def remove_element(nums, val):
    nums[:] = [i for i in nums if i != val]
    return len(nums)

if '__name__' == '__main__':
    assert(remove_element([1,1,2,3], 1) == 2)
    assert(remove_element([1,1,2,3], 2) == 3)
    assert(remove_element([1,1,2,3], 4) == 4)