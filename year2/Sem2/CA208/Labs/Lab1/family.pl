
/* Facts */

/* index 1 and 2 are parents of index 0 */
parents(david, george, noreen).
parents(jennifer, george, noreen).
parents(georgejr, george, noreen).
parents(scott, george, noreen).
parents(joanne, george, noreen).
parents(jessica, david, edel).
parents(sarkmouse, somebody, jessica).
parents(ali, machy, joanne).
parents(dubem, machy, jennifer).
parents(clara, david, edel).
parents(michael, david, edel).
parents(laura, georgejr, susan).
parents(anna, scott, siobhan).

/* Relationships */

/* We use _ for any anonymous variable that wont be used again */
father(X, Y) :- parents(Y, X, _).
male(X) :- father(X, _).
/* 
We use underscore here cus the other variable isnt used
We just want to check if X is the mother of Y
*/
mother(X, Y) :- parents(Y, _, X).
female(X) :- mother(X, _).

grandfather(X, Y) :- father(X, Z), father(Z, Y).
grandfather(X, Y) :- father(X, Z), mother(Z, Y).

grandmother(X, Y) :- mother(X, Z), father(Z, Y).
grandmother(X, Y) :- mother(X, Z), mother(Z, Y).


brother(X, Y) :- male(X), father(Z, X), father(Z, Y), X \= Y.

sister(X, Y) :- female(X), father(Z, X), father(Z, Y), X \= Y.

uncle(X, Y) :- male(X), parents(Y, Z, _), brother(X, Z).
aunt(X, Y) :- female(X), parents(Y, _, Z), sister(X, Z).



cousin(X, Y) :- ((parents(X, A, B), parents(Y, C, D)),
                (brother(A, C); sister(B, D)),
                X \= Y).

# cousin(X, Y) :- ((parents(X, A, B), parents(Y, C, D)),
#                 ((brother(A, C)), brother(B, D));
#                 (brother(A, D), brother(B, C))),
#                 X \= Y.
# cousin(X, Y) :- ((((parents(X, _, Z);parents(X, Z, _)), (parents(Y, _, W), parents(Y, W, _))), (brother(Z, W));mother(Z, W)), X \= Y).