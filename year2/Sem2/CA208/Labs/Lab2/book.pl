book(illiad, homer, study, 500).
book(c, richie, study, 150).
book(ntbible, sams, reference, 480).
book(montypython, cleese, comedy, 300).
book(oythanolgorithms, david, study, 225).
book(lilacbus, binchey, fiction, 200).
book(hamlet, shakespere, drama, 250).
book(leisureBook, shakespere, leisure, 14).

buildLibrary(Lib) :- findall(book(Title, Author, Genre, Size), book(Title, Author,
Genre, Size), Lib).

is_holiday(book(_,_,G,S)):- G\== study, G\== reference, S < 400.
is_revision(book(_,_,G,S)):- G == study, G == reference, S > 300.

holiday(B,[B | _]):- is_holiday(B).
holiday(B , [_ | T]):- holiday(B,T).

is_literary(book(_,_,G,_)):- G == drama.

is_leisure(book(_,_,G,_)):- G == comedy, G == fiction.