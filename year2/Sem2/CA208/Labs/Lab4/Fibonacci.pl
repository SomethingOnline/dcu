% true if Y is the sum of (x - 1) + (x - 2)
% fib of 1 = 1, fib of is 1.
fib(0, 1).
fib(1, 1).

fib(X, N):-
    /*
    % store value of X - whatever in N1 or N2 then check if Y == N1 + N2
    % this is psuedocode
    N = fib(X - 1, N1) + fib(X - 2, N2).
    Y = N1 + N2.
    */
    % real code
    X1 is X - 1,
    X2 is X - 2,
    fib(X1, N1),
    fib(X2, N2),
    N is N1 + N2.

% Area of a triangle
% infix binary operator tA true if right operand is area of triangle defined by left
% for example 6/4 tA X is true if X == 12

% define operator
% priority, infix or postfix or whatever 
% infix means it comes between operator from left to right
% so xfy
% tA is the name of the thing, triangle Area
% binary operator so when we call tA we must give it two variables
% triangle and Area

% defining tA as an operator
:- op(500, xfy, tA).

% base div by height for tA is true if base/height is Area
Base/Height tA Area :- Area is (0.5*Base)*Height.

