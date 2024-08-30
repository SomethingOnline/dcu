% Facts

% form route(src, dest, distance, modes)
% route defines between src and dest and has length distance
% modes is a string that defines the modes of transport available
% if modes has f it can be by foot
% if c then car, if t then train, if p then plane

% avg speeds for each mode of transport
speed('f', 5).
speed('c', 80).
speed('t', 100).
speed('p', 500).

route(dublin, cork, 200, 'fct').
route(cork, dublin, 200, 'fct').
route(cork, corkAirport, 20, 'fc').
route(corkAirport, cork, 25, 'fc').
route(dublin, dublinAirport, 10, 'fc').
route(dublinAirport, dublin, 20, 'fc').
route(dublinAirport, corkAirport, 225, 'p').
route(corkAirport, dublinAirport, 225, 'p').
% testing route
route(dublin, london, 500, 'fctp').

% journey(S, D, M) where S is the source, D is the destination and M is the modes of transport
% base case - S and D are the same location
journey(S, S, _, _, [], 0).
journey(S, D, M, Visited, [(S, L, M1)|Path], Time) :-
    route(S, L, Dist, Modes),  % Find a route from S to L with distance Dist and available modes of transport Modes
    not(member(L, Visited)),  % Check L (intermediate location) has not been visited
    atom_chars(Modes, ModesList),  % Splits ModesList into chars
    memberchk(M1, ModesList),  % Check if M1 (mode of transport) in ModesList 
    atom_chars(M, MList),  % Convert the M atom (modes of transport in query) to a list of characters
    memberchk(M1, MList),  % Check if M1 is in MList
    speed(M1, Speed),  % Get speed of M1
    Time1 is Dist / Speed,  % Calculate the time to travel from S to L using M1
    journey(L, D, M, [L|Visited], Path, Time2),  % Find path from L to D, adding L to list of visited 
    Time is Time1 + Time2.  % Calculate the total time

% helper predicate to find the shortest path
% Base case - If there is only one path (P, T) in the list, then it is shortest path
shortestPath([(P, T)], (P, T)).

% Recursive case for shortestPath predicate:
% If there are multiple paths in the list, the shortest path is determined as follows:
shortestPath([(P1, T1)|Paths], (SP, ST)) :-
    shortestPath(Paths, (P2, T2)),  % Recursively find the shortest path in the remaining paths
    % if time T1 for first path < time for T2 for the shortest path in remaining paths, then shortest path is (P1, T1), else (P2, T2)
    (T1 < T2 -> (SP, ST) = (P1, T1) ; (SP, ST) = (P2, T2)).

% helper predicate to extract modes of transport from the path
% Base case for extractModes predicate: 
% If the path is empty, then the list of modes is also empty.
extractModes([], []).

% Recursive case for extractModes predicate:
% If the path is not empty, then the mode M of the first leg of the path is added to the list of modes.
extractModes([(_, _, M)|T], [M|MT]) :-
    extractModes(T, MT).  % Recursively extract modes from the rest of the path

% journey/3 predicate that finds the fastest mode of transport from a source S to a destination D using the modes of transport specified in M.
journey(S, D, M) :-
    atom_chars(M, MList),
    % Find all possible paths and times from S to D and store them in a list Paths
    findall((Path, Time), (path(S, D, MList, [], Path, Time)), Paths),
    shortestPath(Paths, (ShortestPath, ShortestTime)), 
    extractModes(ShortestPath, Modes),  % Extract the modes of transport from the shortest path
    write('Path: '), write(ShortestPath), nl,  
    write('Mode(s): '), write(Modes), nl,
    % some formatting to print the time in hours or minutes
    (   ShortestTime < 1
    ->  Minutes is ShortestTime * 60,
        write('Time: '), write(Minutes), write(' minutes')  % Print the shortest time in minutes
    ;   ShortestTime =:= 1
    ->  write('Time: '), write(ShortestTime), write(' hour')  % Print the shortest time in hour
    ;   write('Time: '), write(ShortestTime), write(' hours')  % Print the shortest time in hours
    ).

% path/6 helper predicate that finds a path from a source S to a destination D using the modes of transport specified in MList
path(S, D, MList, _, [(S, D, M)], Time) :-
    route(S, D, Dist, Modes),  % Find a route from S to D with distance Dist and available modes of transport Modes
    atom_chars(Modes, ModesList), 
    member(M, ModesList),  % Check if M (a mode of transport) is in ModesList
    member(M, MList),  % Check if M is in MList
    speed(M, Speed),  % Get the speed of M
    Time is Dist / Speed.  % Calculate the time to travel from S to D using M

% Recursive case: If S and D are not the same, then the path is a path from S to an intermediate stop L then from L to D.
path(S, D, MList, Visited, [(S, L, M)|Path], Time) :-
    route(S, L, Dist, Modes),  % Find a route from S to L with distance Dist and available modes of transport Modes
    not(member(L, Visited)),  % Check L (the intermediate stop) not visited yet
    atom_chars(Modes, ModesList), 
    member(M, ModesList),  % Check if M (a mode of transport) is in ModesList
    member(M, MList),  % Check if M is in MList
    speed(M, Speed),  % Get the speed of M
    Time1 is Dist / Speed,  % Calculate the time to travel from S to L using M
    path(L, D, MList, [I|Visited], Path, Time2),  % Recursively find the path from L to D, adding L to the list of visited stops
    Time is Time1 + Time2.  % Calculate the total time to travel from S to D