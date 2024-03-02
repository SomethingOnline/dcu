% strings

% name will convert a string into ASCII chars


% join strings
join_string(Str1, Str2, Str3) :-
    name(Str1, StrList1),
    name(Str2, StrList2),
    name(Str3, StrList3),
    append(StrList1, StrList2, StrList3),
    name(Str3, StrList3). 

% get certain chars from list
name('Derek', List),
% get the char at the 0th index - store as FChar - first char
nth0(0, List, FChar),
% print first char
put(FChar).

% atom_length gets length of string
atom_length('Derek', X).