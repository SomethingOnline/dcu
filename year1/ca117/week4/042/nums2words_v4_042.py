#!/usr/bin/env python3

import sys
nums = {
    0: "zero", 1: "one", 2: "two", 3: "three", 4: "four", 5: "five", 6: "six",
    7: "seven", 8: "eight", 9: "nine", 10: "ten", 11: "eleven", 12: "twelve",
    13: "thirteen", 14: "fourteen", 15: "fifteen", 16: "sixteen", 17: "seventeen",
    18: "eighteen", 19: "nineteen", 20: "twenty", 30: "thirty", 40: "forty",
    50: "fifty", 60: "sixty", 70: "seventy", 80: "eighty", 90: "ninety",
    100: "one hundred"
}
# if num in [12, 13, 14]

for line in sys.stdin:
    output = []
    numbers = line.strip().split()
    for n in numbers:
        if int(n) in nums:
            output.append(nums[int(n)])
        else:
            num1 = n[0]
            num2 = n[1]
            output.append(f"{nums[int(num1) * 10]}-{nums[int(num2)]}")
    print(" ".join(output))
 