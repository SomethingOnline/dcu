
# Q1. Calculate the time complexity of the following script and provide a justification.

def search_q1(Y, n, x):

    for i in range (0, n):
        if Y[i] == x:
            return i
    return -1


Y = ['apple', 'banana', 'mango', 'grapes', 'pineapple', 'durian']
x = "pineapple"

n = len(Y)
result = search_q1(Y, n, x)
if result == -1:
    print("Element is not present in the list")
else:
    print("Element", x, "is present at index", result)


# The time complexity of this code is O(n), this is because it is a linear search algorithm
# The time it takes to search the list grows based on the size of the list.
# This confirms it is O(n) as n = length of the list Y whcih we search through.



# Q2. Our calculation for the following script shows a time complexity of O(logn). Provide a justification.

def search_q2(X, item):
    first = 0
    last = len(X)-1
    found = False
    while first<=last and not found:
        mid = (first + last)//2
        if X[mid] == item:
            found = True
            print("The element item", item, "was found at index ", X.index(60))
        else:
            if item < X[mid]:
                last = mid - 1
            else:
                first = mid + 1
    return found


print(search_q2([10, 15, 35, 42, 60, 70, 82, 94], 60))


# The time complexity for this question is O(log(n)) because it is a binary search algorithm
# It is O(log(n)) because it repeatedly divides the input in half until it has found its desired result.
# N is the number of elements of the list 'X'



# Q3. Calculate the time complexity of the following script and provide a justification.

test = 0
n = 10
for i in range(n):
   test = test + 1

for j in range(n):
   test = test - 1


# The time complexity of this program is O(n) as both loops have time complexities of O(n)
# This means the time it takes to run the code is dependant on the size of the variable 'n'


# Q4. Calculate the time complexity of the following script and provide a justification.

i = n
while i > 0:
   k = 2 + 2
   i = i // 2


# The time complexity of this program is O(log(n)) 
# This is because i is constantly divided by 2 until it reaches 0
# It is a binary search algorithm.


# Q5. Calculate the time complexity of the following script and provide a justification.

mat = [[1, 2, 3], [1, 1, 1], [5, 7, 8]]
add = 0
for i in range(len(mat)):
    for j in range(len(mat[0])):
        add += mat[i][j]
print(add)


# The time complexity of this program is n^2
# This is because there is a nested for loop within the other loop
# A standard for loop has time complexity O(n)
# Therefore a nested for loop has O(n^2)


# Q6. Provide a justification on why the following script has an exponential time complexity.

def fibonacci(n):
    if n<2:
        return n
    return fibonacci(n-1) + fibonacci(n-2)


for n in range(2,12,2):
    print("Series sum for {} is {}".format(n, fibonacci(n)))


# The time complexity for this is O(2^n) where n is the n passed to the fibonacci function.
# The program calculates the Finonacci numbers recursively
# The reason this is exponential is because it breaks it down into (n - 1) and (n - 2)
# This breaks the problem down into 2 subproblems which then increase exponentially as the series grows.
# Each level of this subproblem doubles the amount of calls compared to the previous level.
# This makes this script inefficient for larger values of the number 'n'

