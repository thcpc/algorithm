package datastructures.dynamicarray;

import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {

    private T[] arr;
    private int len = 0;
    private int capacity = 0;

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int capacity) {
        this.capacity = capacity;
    }

    public int size(){ return len; }

    public boolean isEmpty(){ return this.size() == 0;}

    public void add(T elem){
        if((len + 1)>=capacity){
            if(capacity == 0) capacity = 1;
            else capacity *= 2;
            T[] new_arr = (T[]) new Object[capacity];
            for(int i = 0;i<len;i++) new_arr[i] = arr[i];
            arr = new_arr;
        }
        arr[len++] = elem;
    }

    public T removeAt(int index){
        T data = arr[index];
        T[] new_arr = (T[]) new Object[len-1];
        for(int i = 0, j = 0; i<len; i++,j++){
            if(i == index) j--;
            else new_arr[j] = arr[i];
        }
        arr = new_arr;
        capacity = --len;
        return data;
    }

    public int indexOf(Object obj){
        for(int i =0;i<len;i++){
            if(obj == null) {
                if(arr[i] == null) return i;
            }else{
                if(obj.equals(arr[i])) return i;
            }
        }
        return -1;
    }


    public Iterator<T> iterator() {
        return null;
    }
}


