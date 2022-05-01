package org.example;

import java.util.Iterator;

public class MyListIterator<T> implements Iterator<T> {

    private final MyList<T> listInstance;

    private MyListElement<T> cursor;

    public MyListIterator(MyList<T> listInstance){
        this.listInstance = listInstance;
        this.cursor = listInstance.head;
    }

    @Override
    public boolean hasNext() {
        return this.cursor != null;
    }

    @Override
    public T next() {
        MyListElement<T> lastCursor = this.cursor;
        this.cursor = this.cursor.next;
        return lastCursor.value;
    }
}
