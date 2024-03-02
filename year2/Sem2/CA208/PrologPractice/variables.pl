% variables 

male(albert).
male(bob).
male(bill).
male(carl).
male(charlie).
male(dan).
male(edward).
 
female(alice).
female(betsy).
female(diana).

parent(albert, bob).
parent(albert, betsy).
parent(albert, bill).
 
parent(alice, bob).
parent(alice, betsy).
parent(alice, bill).
 
parent(bob, carl).
parent(bob, charlie).


happy(albert).
happy(alice).
happy(bob).
happy(bill).
with_albert(alice).

brother(bob, bill).

dances(alice) :-
    happy(alice),
    with_albert(alice).

get_grandchild :- 
    parent(albert, X),
    parent(X, Y),
    write('Alberts grandchild is: '),
    write(Y), nl.

get_grandparent:- 
    parent(X, carl),
    parent(X, charlie),
    % ~w = variable
    % ~s = string
    % ~n = newline
    % do the format first, then a list of what we want to pass as the variable
    format('~w ~s grandparent ~n', [X, "is the"]).

% find Y as grandparent of X
% using X and Y allows us to pass our variables at runtime
grand_parent(X, Y) :- 
    parent(Z, X),
    parent(Y, Z).

blushes(X) :- human(X).
human(derek).

stabs(tybalt, mercutio, sword).
hates(romeo, X) :- stabs(X, mercutio, sword).


% Anonymous variable
