% conditionals 

what_grade(5) :-
    write('Go to kindergarten').
what_grade(6) :-
    write('Go to 1st grade').

what_grade(Other) :-
    % Grade is other is the same as Grade = Other - 5
    Grade is Other - 5,
    format('Go to grade ~w', [Grade]).
