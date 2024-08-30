// comparing

Comparing Objects:
Collections such as List provide a convenient sort function that allows us to 
sort a list based on comparison, However, in order to do this we need
to specify how to compare two values.
If they are integers we compare smaller and larger.
For strings, we can presume ordering based on the alphabet or character orders.

Comparable:
The comparable interface only consists of one method: compareTo(T o)
that takes in an object of type T (using generics) and returns an int
which can be "one of -1, 0 or 1" according to whether this value is positive, 
negative or zero.
To implement comparable a class needs to specify the type (for generics) and 
implement the method compareTo for that type.
class Player implements Comparable<Player>{
    private int rank;
    public int compareTo(Player player){
        return Integer.compare(this.rank, player.rank);
    }
}

In the above the interface was extended using generics, but for a specific type
because the class wants an explicit and specific implementation rather than
being a reusable generic class itself, e.g Player<T> implements Comparable<T>
represent Player being generic, 
In the compareTo method, the Integer.compare function returns 1, 0, -1 value
by comparing two ints passed to it

To use comparable in sorting we can use Collections.sort() which is a generic method
for comparing and sorting any Collection (so list, set, queue, etc) based on it
implementing Comparable
for example:
class Player implements Comparable<Player>{
    int rank;
    public int compareTo(Player player){
        return Integer.compare(this.rank, player.rank);
    }
}

// main()
List<Player> players = new ArrayList<>();
Collection.sort(players);

Note that collections is a class and is different from the collection interface,
to avoid confusion, remember that the class and interface names are typically singular.
i.e Collection, List or Set whereas the class Collections is plural and is a helper class
which provides several static methods for convenience of using the Collection
implementing classes.

Since player implements compareTo from the Comparable interface the argument
type is defined by whatever type is using generics - which is why we have 
Comparable<player> 
if no such object was defined then it would be Comparable<Object>
and the class would need to have a method that implements compareTo with
an object argument.

Comparator:
The comparable interface allows a class to express how its objects should be 
compared to one anoher.
The comparator interface represents cases where other classes want to express
how a different class' objects should be compared.

To implemenet comparator, a class needs to specify the type (for generics) and implement
the appropriate method for that type:
class PlayerRanker implements Comparator<Player>{
    public int compare(Player player1, Player player2){
        return Integer.compare(player1.rank, player2.rank);
    }
}

In the above the same comparison is done as before through an external class
called PlayerRanker so that one has to choose to order the players using their
ranks as a metric.
Other classes could be AtheleteTeamSorter that compares whether Players have the same
team or not to group them in teams or go into specific stats of their sport 
such as goals scored for soccer.

To use this class as an implementation for sorting, it can be passed as 
an arg to functions such as that from Collections.sort(list, comparator) or
List.sort(comparator).
List <PLayer> players = new ArrayList();
// Using List.sort()
players.sort(new PlayerRanker());
// using collections.sort
Collections.sort(players, new PlayerRanker());

In this we had to create an instance of PlayerRanker because the sort function
expects an object, not a class.
Instances allow customisation of comparison implementations such as setting 
thresholds for what is considered low or to configure whether nulls should be
considered highest or lowest values so they end on top or bottom etc.