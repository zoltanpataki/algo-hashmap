package com.codecool.hashmap;

public class HashMap<K, V> {
    private int bucket = 16;
    private KeyValue<K, V>[] elements = new KeyValue[bucket];

    public void add(K key, V value){
        if (key == null){
            System.out.println("It doesn't allowed to store null!");
            return;
        }

        int position = hash(key);
        KeyValue<K, V> newElement = new KeyValue<>(key, value, null);

        if (elements[position] == null){
            elements[position] = newElement;
        } else {
            KeyValue<K, V> previous = null;
            KeyValue<K, V> current = elements[position];

            while (current != null){
                if (current.getKey().equals(key)){
                    if (previous == null){
                        newElement.setNext(current.getNext());
                        elements[position] = newElement;
                        return;
                    } else {
                        newElement.setNext(current.getNext());
                        previous.setNext(newElement);
                        return;
                    }
                }
                previous = current;
                current = current.getNext();
            }

            previous.setNext(newElement);

        }
    }

    public V get (K key){
        int position = hash(key);
        if (elements[position] == null){
            return null;
        } else {
            KeyValue<K, V> current = elements[position];
            while (current != null){
                if (current.getKey().equals(key)){
                    return current.getValue();
                }

                current = current.getNext();
            }
        }

        return null;
    }

    public boolean delete(K key){
        int position = hash(key);
        if (elements[position] == null){
            return false;
        } else {
            KeyValue<K, V> previous = null;
            KeyValue<K, V> current = elements[position];

            while (current != null){
                if (current.getKey().equals(key)){
                    if (previous == null){
                        elements[position] = elements[position].getNext();
                        return true;
                    } else {
                        previous.setNext(current.getNext());
                        return true;
                    }

                }
                previous = current;
                current = current.getNext();
            }

            return false;
        }
    }

    public void clearAll(){
        for (int i = 0; i < bucket; i++){
            elements[i] = null;
        }
    }

    public void display(){
        for (int i = 0; i < bucket; i++){
            if (elements[i] != null){
                KeyValue<K, V> current = elements[i];
                while (current != null){
                    System.out.println(current.getKey() + ", " + current.getValue());
                    current = current.getNext();
                }
            }
        }
    }

    private int hash(K key){
        return Math.abs(key.hashCode()) % bucket;
    }
}
