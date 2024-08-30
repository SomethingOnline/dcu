
class(X, negative):-
    X < 0, !.
class(0, zero) :- !.
class(X, positive):-
    X > 0, !.

% base case
relation_split([], [], []).


relation_split([X | T], [X | Positive], Negative):-
    X >= 0, !,
    relation_split(Tail, Positive, Negative).

relation_split([X | T], Positive, [X, Negative]):-
    X < 0, !,
    relation_split(Tail, Positive, Negative)


fib(0, 1) :- !.
fib(1, 1) :- !.

fib(X, N):-
    X > 1,
    X1 is X - 1,
    X2 is X - 2,
    fib(X1, N1),
    fib(X2, N2),
    N is N1 + N2.
