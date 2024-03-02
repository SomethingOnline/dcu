
/* Q1 */
myElem(X, [X|_] ).
myElem(X, [_|Tail]):- myElem(X, Tail).

/* Q2 */
myHead(X, [X|_]).
/* Q3 */
myLast(X, [_|Tail]).

/* Q4 */
myTail(A, B):- append(_,A, B).
/* Q5 */
myAppend([], B, B).
myAppend([X|TailA], B, [X|Result]):- myAppend(TailA, B, Result).


/* Q7 */
# List A = list B without X.

myDelete(X, [X|L], L).
myDelete(X, [Y|Tail], Y[Tail1]):- myDelete(X, Tail, Tail1).