# Q1
def sum_q1(n):
    if n <= 1:
        return n
    else:  
        ans = sum_q1(n - 1)
    return n + ans


# Q2

def reverse_integer(n, reverse=0):
    if n == 0:
        return reverse
    else:
        reverse = reverse * 10 + n % 10
        return reverse_integer(n // 10, reverse)
    

# Q3
def reverse(string):
    if len(string) == 0:
        return string
    else:
        return reverse(string[1:]) + string[0]
    
# Q4
def reverse(list):
    if len(list) == 0:
        return []

    elif len(list) == 1:
        return list

    return [list[len(list) - 1]] + reverse(list[:len(list) - 1])

# Q5
def multiply(a, b):
    if b == 0:
        return 0
    if a < 0:
        return -(b - multiply(b, a + 1))
    else:
        return b + multiply(b, a - 1)

# Q6
def is_heteromecic(n, x=0):
    if x * (x + 1) < n:
        return is_heteromecic(n, x + 1)
    else:
        return x * (x + 1) == n

# Q7
def recursive_string_length(input_string):
    if len(input_string) == 0:
        return 0
    else:
        return 1 + recursive_string_length(input_string[1:])