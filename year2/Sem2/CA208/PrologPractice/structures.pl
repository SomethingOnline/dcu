% structures

% functor, followed by lists of args
% female = functor
% alice = list of args
% num of elements in list of args = ARITY

female(alice). % arity of 1

owns(albert, pet(cat, olive)).

customer(tom, smith, 20.55).
customer(sally, smith, 120.55).

get_customer_bal(FName, LName) :-
    customer(FName, LName, Bal),
    % ~w is Last name, ~2f is balance number rounded to 2 spaces
    format('~w Owes us euro ~2f ~n', [LName, Bal]).

vertical(line(point(X, Y), point(X, Y2))).

horizontal(line(point(X, Y), point(X2, Y))).