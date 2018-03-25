package com.codecool.hashmap;

public class KeyValue<Key, Value> {
    private Key key;
    private Value value;
    private KeyValue<Key, Value> next;

    public KeyValue(Key key, Value value, KeyValue<Key, Value> next){
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public KeyValue<Key, Value> getNext() {
        return next;
    }

    public void setNext(KeyValue<Key, Value> next) {
        this.next = next;
    }
}
