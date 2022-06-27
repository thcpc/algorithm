package datastructures.linkedlist;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DoublyLinkList<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private static class Node<T>{
        private T data;
        private Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    /***
     * prev 节点， next节点， data都置为空值
     */
    public void clear(){
        Node<T> trav = head;
        while (trav != null){
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        size = 0;
        head = tail = trav = null;
    }

    public int getSize() {
        return size;
    }

    public void append(T elem){
        addLast(elem);
    }

    public void insert(T elem){
        addFirst(elem);
    }

    public boolean isEmpty(){ return size == 0;}

    public void addLast(T elem){
        if(isEmpty()){
            head = tail = new Node<>(elem, null, null);
        }else {
            Node<T> newNode = new Node<>(elem, tail, null);
            tail.next = newNode;
            tail = newNode;
        }
        size ++;
    }

    public void addFirst(T elem){
        if(isEmpty()){
            head = tail = new Node<>(elem, null ,null);
        }else {
            head.prev = new Node<>(elem, null,head);
            head = head.prev;
        }
        size ++;
    }

    public void add(T elem, int index){
        if(index< 0 || index>size) throw new IllegalArgumentException("Illegal index");
        if(index == 0) { addFirst(elem); return;}
        if(index == size) { addLast(elem); return;}
        Node<T> trav = head;
        for(int i = 0; i<index+1; i++){
            trav = trav.next;
        }
        Node<T> newNode = new Node<T>(elem,trav,trav.next);
        trav.next.prev = newNode;
        trav.next = newNode;
        size ++;
    }

    public T peekFirst(){
        if(isEmpty()) throw new RuntimeException("Empty");
        return head.data;
    }


    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> trav = head;
            @Override
            public boolean hasNext() {
                return trav!=null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }

    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
