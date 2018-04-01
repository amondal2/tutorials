def search_insert(nums, target):
    if target < nums[0]:
        return 0
    elif target > nums[-1]:
        return len(nums)
    else:
        for i in range(len(nums)):
            if target <= nums[i]:
                return i
    return -1

assert(search_insert([1,3,5,6],5) == 2)
assert(search_insert([1,3,5,6],2) == 1)
assert(search_insert([1,3,5,6],7) == 4)
assert(search_insert([1,3,5,6],0) == 0)