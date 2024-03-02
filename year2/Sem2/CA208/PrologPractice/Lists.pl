% Lists

% | is list constructor

% use reverse to reverse a list
% reverse([1, 2, 3], X) new list is now X

% use length to find the length of a list

% use member to check if an item is a part of a list
% member(a, [a, b, c]).

% use append to concatenate a list
% append([1, 2, 3], [4, 5, 6], X).

% cycle through a list
% base case to deal with empty list
write_list([]).
% recursion body
write_list([Head|Tail]) :-
    write(Head), nl,
    % will keep looping through without the head as head gets updated every pass
    write_list(Tail).
