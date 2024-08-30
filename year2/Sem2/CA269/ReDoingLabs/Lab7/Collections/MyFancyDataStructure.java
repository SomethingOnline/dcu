

enum SortingOrder{
	LOWER, HIGHER;
}


class PreferenceComparator implements Comparator<Value>{
	private SortingOrder sortOrder;
	PreferenceComparator(SortingOrder sortOrder){
		this.sortOrder = sortOrder;
	}

	public int compareTo(Value v1, value 2){
		if (sortOrder == SortingOrder.LOWER){
			return Integer.compare(v1.getValue(), v2.getValue());
		} else{
			return Integer.compare(v2.getValue(), v1.getValue());
		}
	}
}

class PreferenceComparatorFactory{
	public static PreferenceComparator getNewPreferenceComparator(SortingOrder order){
		return new PreferenceComparator(order);
	}
}

class PreferenceComparatorShop{
	private PreferenceComparator LowerComparator;
	private PreferenceComparator HigherComparator;

	PreferenceComparatorShop(PreferenceComparator LowerComparator, PreferenceComparator HigherComparator){
		this.LowerComparator = LowerComparator;
		this.HigherComparator = HigherComparator;
	}

	public PreferenceComparator getLowerComparator(){
		return LowerComparator;
	}
	public PreferenceComparator getHigherComparator(){
		return HigherComparator;
	}
}

class ThresholdComparator implements Comparator<Integer>{
	private int max;
	private int min;
	ThresholdComparator(int min, int max){
		this.min = min;
		this.max = max;
	}

	public int getMax(){
		return max;
	}
	public int getMin(){
		return min;
	}
	public int compare(Integer a, Integer b){
		boolean AinRange = a >= min && a <= max;
		boolean BinRange = b >= min && b <= max;

		if (AinRange && BinRange){
			return a.compareTo(b);
		}
		if (AinRange){
			return -1;
		}
		if (BinRange){
			return 1;
		}

		return Integer.compare(b, a);
	}
}




public class MyFancyDataStructure {
    public static void main(String[] args) {
        List<Value> list = Arrays.asList(
            new Value(2), new Value(3), new Value(1)
        );

        Value.setSortLower();
        Collections.sort(list);
        System.out.println(list);

        Value.setSortHigher();
        Collections.sort(list);
        System.out.println(list);
    }
}

class PreferLowerValues implements Comparator<Value>{
	public int compare(Value v1, Value v2){
		return Integer.compare(v1.getValue(), v2.getValue());
	}
}

class PreferHigherValues implements Comparator<Value>{
	public int compare(Value v1, Value v2){
		return Integer.compare(v2.getValue(), v1.getValue());
	}
}

class Value implements Comparable<Value>{
	private final int value;
	private static boolean SORT_LOWER;
	public int getValue(){
		return value;
	}
	Value(int value){
		this.value = value;
	}

	public static boolean getSortLower(){
		return SORT_LOWER;
	}
	public static boolean getSortHigher(){
		return !SORT_LOWER;
	}
	public static void setSortLower(){
		SORT_LOWER = true;
	}

	public static void setSortHigher(){
		SORT_LOWER = false;
	}

	public static boolean isSortLower(){
		if (SORT_LOWER == true){
			return true;
		}
	}
	public static boolean isSortHigher(){
		if (SORT_LOWER == false){
			return true;
		}
	}

	public int compareTo(Value other){
		if (isSortLower()){
			return this.value - other.value;
		} else{
			return other.value - this.value;
		}

	}

	public String toString(){
		return this.value;
	}
}

