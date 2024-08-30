/* Lists */

myElem(X, [X | _]).

myElem(X, [_, T]):-
    myElem(X, T).


myHead(X, [X | _]).

% One item in list - always true
myLast(X, [X]).
% Multiple items in list - need to check last item
myLast(X, [_ | T]):-
    myLast(X, T).


myTail(X, [_ | X]).

% True if L1 + L2 = L3
% BASE CASE = EMPTY LIST
myAppend([], L, L).

% recursive case, L3 = Same head of L1 + tail of l1 + list2 (L3).
myAppend([H | T], L, [H | L3]):-
    % L3 is the same of tail of L1 + L2.
    % already matched the head in the function parameters so no need to check.
    % returns true because L is append to Tail1 to make L3.
    myAppend(T, L, L3).


myReverse([], []).
% recursive case
myReverse([X | T], Y):-
    % Remove head, reverse tail and append X to tail
    myReverse(T, T1),
    myAppend(T1, [X], Y).

% BASE CASE, TAKES 3 ARGS, X AND L1 AND L2, 
% TRUE IF DELETE X FROM L1 AND GET L2
myDelete(X, [X | T], [T]).

myDelete(X, [Y | T], [Y | L]):-
    myDelete(X, T, L).
