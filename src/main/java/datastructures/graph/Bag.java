package datastructures.graph;

import datastructures.linkedlist.DoublyLinkList;

import java.util.Iterator;
import java.util.function.Consumer;

public class Bag <T> implements Iterable<T>{
    private DoublyLinkList<T> linkList;

    public Bag() { this.linkList = new DoublyLinkList<T>();}

    public void add(T elem) { linkList.insert(elem);}

    public int size() { return linkList.getSize();}

    public boolean isEmpty(){ return linkList.isEmpty(); }

    @Override
    public Iterator<T> iterator() {
        return linkList.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        linkList.forEach(action);
    }
}
