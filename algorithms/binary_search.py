# python implementation of binary search
import math

def binary_search(array, value):
    left = 0
    right = len(array)-1
    while left <= right:
        middle = math.floor((left+right)/2)
        if array[middle] < value:
            left = middle+1
        elif array[middle] > value:
            right = middle - 1
        else:
            return middle
    return False


if __name__ == '__main__':
    assert binary_search([1,2,3],1) == 0
    assert binary_search([1,2,3],2) == 1
    assert binary_search([1,2,3],3) == 2

    assert binary_search([1,2,3,4,5], 6) == False
    assert binary_search([1,3,5,6,7], 3) == 1

