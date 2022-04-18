package org.example;

public class MyStringListElement {

    public String value;

    public MyStringListElement next;

    public MyStringListElement clone(){
        MyStringListElement copy = new MyStringListElement();
        copy.value = this.value;
        return copy;
    }

}
