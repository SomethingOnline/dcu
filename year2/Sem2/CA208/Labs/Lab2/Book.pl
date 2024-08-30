% define books
book(illiad, homer, study, 500).
book(c, richie, study, 150).
book(bible, sams, reference, 450).
book(monty, cleese, comedy, 300).
book(pride, austen, drama, 250).
book(big_sleep, chandler, crime, 200).
book(harry_potter, rowlings, fiction, 350).

% define data structure
% findall finds everything that matches these attributes
% then puts it in into a list with the same attribtues as defined after
% name of data structure = Lib - defined at the end.

buildLibrary(Lib) :- findall(book(Title, Author, Genre, Size), book(Title, Author, Genre, Size), Lib).


% check for holiday books

% checks individual book
/*
is_holiday(Book) :-
    Book = book(_, _, G, S),
    % book holiday book if not study or reference
    G \== study,
    G \== reference,
    % if size < 400
    S < 400.
*/

is_leisure(book(_, _, G, _)):-
    G == comedy,
    G == fiction.
leisure(B, [B, _]):-
    is_leisure(B).
leisure(B, [_, T]):-
    leisure(B, T).

% or instead of defining what Book is, i can put it in the predicate
is_holiday(book(_, _, Genre, Size)):-
    % book holiday book if not study or reference
    Genre \== study,
    Genre \== reference,
    % if size < 400
    integer(Size),
    Size < 400.

is_revision(book(_, _, Genre, Size)):-
    Genre == revision,
    Genre == study,
    Size > 300.

is_literary(book(_, _, Genre, _)):-
    Genre == drama.
literary(B, [B | _]):-
    is_literary(B).
literary(B, [_, T]):-
    literary(B, T).

revision(B, [B | _]):-
    is_revision(B).
revision(B, [_, T]):-
    revision(B, T).

/*
% now check entire library
holiday(Book, Lib) :-
    % Lib = List of books
    Lib = [H | Tail],
    H = Book,
    % BASE CASE
    % head of list is a holiday book
    is_holiday(H).
*/

/* or again just match in the actual call */
holiday(B, [B | _]):-
    is_holiday(B).
holiday(B, [_ | T]):-
    % recursive case, Head is not a book so we check rest of the Tail
    holiday(B, T).
