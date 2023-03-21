#!/usr/bin/env python3


d = {')' : '(', 
     '}' : '{',
     ']' : '['
}

# is current char a lefty, ie is it in d.values()
# if it is remember it , ie push ( onto the stack, remember its on the left

# ( [ ] )
# stack = ( [
# on meeting a righty
# pop element currently at the top and verify the current right closes the lefty
# aka the one thats popped from the stack is matched in the dict and then get rid of it
# right = key, left = values

# return if stack is empty or not , if empty then all matches, else not.
