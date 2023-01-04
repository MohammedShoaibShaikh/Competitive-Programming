# Recursive function to Convert String to Integer

def strToInt(n):
    if(len(n) == 1):
        return ord(n[0]) - ord('0')
    
    smallProb = strToInt(n[1:])
    firstDigit = ord(n[0]) - ord('0')
    return firstDigit * (10**(len(n)-1)) + smallProb
    
# Main
n = input("Enter String: ")
print("The Integer:" , strToInt(n))