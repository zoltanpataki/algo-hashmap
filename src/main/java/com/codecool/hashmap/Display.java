package com.codecool.hashmap;

public class Display {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        map.add("valami", 85);
        map.add("macika", 77);
        map.add("mogyika", 24);
        map.add("luluka", 17);
        System.out.println(map.get("valami"));
        map.display();
        map.clearAll();
        System.out.println(map.delete("valami"));
    }
}
