import time

def summation(n):
    print("Execute by Cython")
    result = 0
    for i in range(1, n+1):
        result +=i
    return result
