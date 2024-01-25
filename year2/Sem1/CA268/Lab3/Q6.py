
#Pronic number = product of 2 integers
# Recursively
# n(n + 1)

# 110 = True
# 10 * (10 + 1) = 10 * 11 = 110

# Psuedocode
# if m * (m + 1) < n:
#     recursion(n, m + 1)
# else:
#     return m * (m + 1) == n



# def is_heteromecic(num):
#     n = num
#     m = 0


def recursion(n, m = 0):
    if m * (m + 1) < n:
        return recursion(n, m + 1)
    else:
        return m * (m + 1) == n
print(recursion(42))
