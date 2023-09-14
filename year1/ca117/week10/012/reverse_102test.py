
# def reverse(list, n):
#     if len(list) == 0:
#         return 0
#     else:
#         return list[-1] 
def reverse(list, n):
    if len(list) == 0:
        return 0
    else:
        list[-(n + 1)]
        lastElement = reverse(list, len(list))
        list.append(lastElement)

# print(reverse([3,4,5,6]))
# print(reverse([1,2]))

def main(arr):
    list = []
    print(list)
    
main(([1,2,3]))