package org.example;

public class MyListElement<T> {

    public T value;

    public MyListElement<T> next;

    @Override
    public MyListElement<T> clone(){
            MyListElement<T> copy = new MyListElement<>();
            copy.value = this.value;
            return copy;
        }
    }
