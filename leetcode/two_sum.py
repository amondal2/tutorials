def twoSum(nums, target):
	for i in range(len(nums)):
		for j in range(len(nums)):
			if nums[i] + nums[j] == target and i is not j:
				return [i, j]

