public interface Order {
    public boolean lessThan(Order other);
}


class Comparator<T extends Order>{

	public T getLesser(T x, T y){
		if (x.lessThan(y)){
			return x;
		} else if (y.lessThan(x)){
			return y;
		} else{
			return null;
		}
	}

	public T getLarger(T x, T y){
		T answer = getLesser(x, y);
		if (answer == x){
			return y;
		} else if(answer = y){
			return x;
 		} else{
			return null;
		}
	}
}