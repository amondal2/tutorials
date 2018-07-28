# memoized fibonnaci sequence
memo = {}
def fib(n):
    if n < 2:
        return 1
    else:
        if n in memo:
            return memo[n]
        else:
            ret = fib(n-1) + fib(n-2)
            memo[n] = ret
            return ret

if __name__ == '__main__':
    for i in range(0,10):
        print(fib(i))