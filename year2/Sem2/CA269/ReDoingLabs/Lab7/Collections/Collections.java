// Comparing objects
// collections provide sort function but we must define how to compare it
// for classes its not obvious, we need to use comparable interface

// comparable has one method - compareTo(T o)
// returns -1 if neg, 0 is zero and 1 if positive


class Player implements Comparable<Player>{
	private int rank;
	public int compareTo(Player player){
		return Integer.compare(this.rank, player.rank);
	}
}

// we can use collecitons.sort() based on the implementation of comparable
List<Player players = new Arraylist<Player>();
Collections.sort(players);


// Comparator
// classes want to express how a different classes objects should be compared

// same comparsion is done through new class PLayerranker
// so one has to choose to order the players using their ranks as a metric

class PlayerRanker implements Comparator<Player>{
	public int compare(Player player1, Player player2){
		return Integer.compare(player1.rank, player2.rank);
	}
}
List<Player> players = new Arraylist<>();
// using list.sort()
players.sort(new PlayerRanker());
// using collections.sort()
// we had to make new instance because playerranker expects an object, not a class
Collections.sort(players, new PlayerRanker());