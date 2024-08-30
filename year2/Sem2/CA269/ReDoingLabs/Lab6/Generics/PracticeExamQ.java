
public interface Order{
	public boolean lessThan(Order other);
}

class Comparator<T extends Order>{
	public T getLesser(T p1, T p2){
		if(p1.lessThan(p2)){
			return p1;
		} else if(p2.lessThan(p1)){
			return p2;
		} else{
			return null;
		}
	}

	public T getGreater(T p1, T p2){
		T lesser = getLesser(p1, p2);
		if (lesser == p1){
			return p2;
		} else if(lesser == p2){
			return p1;
		} else{
			return null;
		}
	}

	public static void main(String[] args){
		Comparator<Point> C = new Comparator<>();

		Point P1 = new Point(0, 0);
		Point P2 = new Point(1, 1);
		System.out.println(C.getLesser(P1, P2)); // (0.0, 0.0)
		System.out.println(C.getLesser(P2, P1)); // (0.0, 0.0)
		System.out.println(C.getLesser(P1, P1)); // null

	}
}