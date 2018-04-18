package com.jbksoft.hackerrank.HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapImpl {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public HashMapImpl(String magazine, String note) {
        magazineMap=new HashMap<String, Integer>();
        noteMap=new HashMap<String, Integer>();

        for( String s: magazine.split(" ")){
            Integer oldVal=magazineMap.put(s,new Integer(1));
            if(oldVal!=null){
                magazineMap.put(s,new Integer(oldVal+1));
            }
        }

        for( String s: note.split(" ")){
            Integer oldVal=noteMap.put(s,new Integer(1));
            if(oldVal!=null){
                noteMap.put(s,new Integer(oldVal+1));
            }
        }

    }

    public boolean solve() {

        for(Map.Entry<String,Integer> entry:noteMap.entrySet()){
            String note=entry.getKey();
            Integer count=entry.getValue();
            Integer tCount=magazineMap.get(note);

            if(tCount<count){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        HashMapImpl s = new HashMapImpl(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}
