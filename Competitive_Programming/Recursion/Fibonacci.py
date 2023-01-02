def fib(n):
    if(n == 0):
        return 0
    if(n == 1):
        return 1
    ans = fib(n-1) + fib(n-2)
    return ans
    

# Main
n = int(input("Enter Value of Index N: "))
print(str(n) + "th number in Series is", fib(n))