% fact
loves(romeo, juliet).

% rule
% juliet will love romeo IF romeo loves juliet
loves(juliet, romeo) :- loves(romeo, juliet).

% write relations first, then objects between () followed by a .
% atoms always begin with lowercase

% keep same grouped together
happy(albert).
happy(alice).
happy(bob).
happy(bill).

with_albert(alice).
% near_water(bob).

% :- if statement
runs(albert) :- 
    happy(albert).

dances(alice) :- 
    happy(alice),
    with_albert(alice).


does_alice_dance :- dances(alice), 
    write('When alice is happy and with albert she dances').

% and statement using if
swims(bob) :- 
    happy(bob),
    near_water(bob).

% or statement using if
% this will return true even tho we have not defined near_water
% because the first clause is correct so the 2nd one does not need to be checked
% if we want to use an or statement we need 2 different functions
swims(bill) :-
    happy(bill).

swims(bill) :- 
    near_water(bill).