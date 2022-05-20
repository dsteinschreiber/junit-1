package org.example;

import java.util.Iterator;

public class MyListIterator<T> implements Iterator<T> {

    private final MyList<T> listInstance;

    private MyListElement<T> cursor;

    private MyListElement<T> lastCursor;

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
        this.lastCursor = this.cursor;
        this.cursor = this.cursor.next;
        return this.lastCursor.value;
    }

    @Override
    public void remove() {
        if (this.lastCursor == null){
            throw new IllegalStateException();
        }
        this.listInstance.remove(this.lastCursor);
        this.lastCursor = null;
    }
}
