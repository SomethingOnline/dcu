import java.util.*;


class Value implements Comparable<Value> {
    final int value;
    private static boolean SORT_LOWER;

    Value(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
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

    @Override
    public int compareTo(Value other) {
        if(getSortLower()){
            return this.value - other.value;
        } else {
            return other.value - this.value;
        }
    }

    @Override
    public String toString(){
       return String.valueOf(value);
    }
}

class PreferLowerValues implements Comparator<Value> {
    @Override
    public int compare(Value v1, Value v2) {
        return Integer.compare(v1.getValue(), v2.getValue());
    }
}

class PreferHigherValues implements Comparator<Value> {
    @Override
    public int compare(Value v1, Value v2) {
        return Integer.compare(v2.getValue(), v1.getValue());
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