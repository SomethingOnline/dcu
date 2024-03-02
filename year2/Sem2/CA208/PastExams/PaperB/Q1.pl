parent(carol, paul).
parent(carol, jane).
parent(harry, tom).
parent(harry, mary).
parent(jim, tom).
parent(jim, mary).
parent(ann, tom).
parent(ann, mary).
parent(tim, harry).
parent(tim, carol).
parent(george, harry).
parent(george, carol).
parent(jenny, harry).
parent(jenny, carol).
parent(david, jim).
parent(david, joan).
parent(kate, jim).
parent(kate, joan).
parent(susan, dominic).
parent(susan, ann).
male(paul).
male(tom).
male(harry).
male(jim).
male(dominic).
male(tim).
male(george).
male(david).
female(jane).
female(mary).
female(carol).
female(joan).
female(ann).
female(jenny).
female(kate).
female(susan).


mother(X, Y):-
    female(X),
    parent(Y, X).

father(X, Y):-
    male(X),
    parent(Y, X).


sister(X, Y):-
    female(X),
    father(Z, Y),
    father(Z, X).

brother(X, Y):-
    male(X),
    father(Z, Y),
    father(Z, X).

aunt(X, Y):-
    sister(X, Z),
    parent(Y, Z).

siblings(X, Y):-
    brother(X, Y),
    sister(X, Y).

cousin(X, Y):-
    parent(X, Z),
    parent(Y, W),
    siblings(W, Z).

paternalgrandmother(X, Y):-
    mother(X, Z),
    father(Z, Y).


% base case
fizzbang([], []).

multiple_of_3(X):-
    0 is X mod 3.
multiple_of_5(X):-
    0 is X mod 5.

fizzbang([Head| Tail], [Head|FilteredTail]):-
    (   multiple_of_3(Head);
        multiple_of_5(Head)
    ),
    fizzbang(Tail|FilteredTail).

fizzbang([Head|Tail], [Head|FilteredTail]):-
    \+ (multiple_of_3(Head); multiple_of_5(Head)),
    fizzbang(Tail|FilteredTail).
