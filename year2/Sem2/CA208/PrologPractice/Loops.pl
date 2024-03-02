% loops


count_to_10(10):-
    write(10), nl.

% using recursion
count_to_10(X):-
    write(X), nl,
    Y is X + 1,
    count_to_10(Y).

count_down(Low, High):-
    between(Low, High, Y),
    Z is High - Y,
    write(Z), nl.
count_up(Low, High):-
    between(Low, High, Y),
    Z is Y + Low,
    write(Z), nl.


% guessing game, get user to guess until correct
guess_num:- loop(start).

loop(15) :-
    write('You got it').
loop(X) :-
    X \= 15,
    write('guess number'),
    read(Guess),
    write(Guess),
    write(' is not the number'), nl,
    loop(Guess).


