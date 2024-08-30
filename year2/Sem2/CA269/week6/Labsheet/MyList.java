import java.util.List;

interface MyList<E> {
    void add(E e);
    void add(E e, int pos);
    E remove();
    E remove(int pos);
    void clear();
    int size();
    int contains(E e);
}

class MyArrayList<E> implements MyList<E>{
    private E[] array = (E[]) new Object[100];
    private int size = 0;
    public void add(E e){
        this.array[size] = e;
        size += 1;
    }
    public String toString(){
        String output = "[";
        for (int i = 0; i < size; i++){
            output += array[i] + ", ";
        }
        return output + "]";
    }

    // todo 
    // add to position
    public void add(E e, int position){
        for (int i = 0; i >= position && i < size; i++){
            this.array[i + 1] = array[i];
        }
        this.array[position] = e;
        size += 1;
    }
    // remove from end
    public E remove(){
        int lastElement;
        lastElement = this.array[size - 1];
        this.array[size - 1] = null;
        size -= 1;
        return lastElement;
    }
    // remove at pos
    public int remove(int position){
        int elementAtPostion = this.array[position];
        this.array[position] = null;
        size -= 1;
        return elementAtPostion;
    }
    // clear
    public void clear(){
        for (int i = 0; i < size; i++){
            this.array[i] = null;
        }
    }
    // size
    public int size(){
        return size;
    }
    // contains
    public int contains(E e){
        for (int i = 0; i < size; i++){
            if (array[i].equals(e)){
                return e;
            }
            return false;
        }
    }

}