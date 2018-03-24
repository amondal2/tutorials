def num_jewels(jewels, stones):
    jewel_map = {}
    for i in range(len(jewels)):
        jewel_map[jewels[i]] = True
    
    count = 0
    for j in range(len(stones)):
        if stones[j] in jewel_map:
            count += 1
    
    return count

assert(num_jewels("aA", "aAAbbbb") == 3)
assert(num_jewels("z", "ZZ") == 0)
