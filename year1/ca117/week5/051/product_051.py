#!/usr/bin/env python3

# x = sys.stdin.readline()
# x in range 1-10000
# multiply its non zero digits produces another int Y
# repeating this we get a digit between 1 - 9
# ex 707
#  7 * 7 = 49
#  4 * 9 = 36
#  3 * 6 = 18
#  1 * 8 = 8


# Working solution , but not best practice
import sys

x = sys.stdin.readline().strip()
while 9 < int(x):
    x = str(x)
    nums = [int(i) for i in x]
    product = 1
    for i in nums:
        if i != 0:
            product *= i
    x = product

print(x)


# Darragh Solution:
# Sketch the body first - not complete
 
numstr = '707'
digits = [int(c) for c in numstr if int(c) != 0]

result = 1
for d in digits:
    result = result * d        # for each digit in the list, first iteration
                               # 7 * 1, then result = 7, now next iteration 7 * 7
print(result)                  # 49

numstr = str(result)    # so can loop back through

# Working function
#!/usr/bin/env python3

import sys
def getProduct(numStr):
    while True:
        digits = [int(c) for c in numStr if int(c) != 0]
        result = 1
        for d in digits:
            result = result * d
        if result >= 1 and result <= 9:
            return result
        else:
            numStr = str(result)

line = sys.stdin.readline().strip()
print(getProduct(line))