package com.jbksoft.collections;

import java.lang.reflect.Field;
import java.util.*;

/**
 * List
 *
 * ArrayList
 * Vector
 * LinkedList
 * CopyOnWriteArrayList
 * Queue --No concrete
 * Stack --Concrete
 * PriorityQueue -Min Heap
 *
 *Set
 *HashSet
 *TreeSet
 *LinkedHashSet
 *
 * Map
 * HashMap
 * Hashtable
 * TreeMap
 * LinkedHashMap
 *
 * WeakhashMap
 * ConcurrentHashMap
 *
 */
public class MyHashMap{

    public static void main(String[] args) throws Exception{

        StringBuffer buffer=new StringBuffer();
        String str[]={"Value","of","each","letter","in"};
        for(String s:str){
            buffer.append(s);
        }

        StringBuilder builder=new StringBuilder();
        for(String s:str){
            builder.append(s);
        }

        ArrayList list=new ArrayList();
        list.add("AA");
        list.add("BB");
        list.add("CC");

        list.add("AA");
        list.add("BB");
        list.add("CC");
        list.add("AA");
        list.add("BB");
        list.add("CC");
        list.add("CC");
        list.add("CC");

        System.out.println(getCapacity(list));

        Iterator iter=list.iterator();

        while(iter.hasNext()){

            System.out.println(iter.next());
        }

        HashSet<String> set=new HashSet();
        set.add("SS1");
        set.add("SS2");

        Iterator setItr=set.iterator();
        while(setItr.hasNext()){
            System.out.println((String)setItr.next());

        }

/*

        HashMap map=new HashMap();
        map.put("AA","comments1");
        map.put("BB","comments2");

        Iterator<Map.Entry<String, String>> iter1=map.entrySet().iterator();
        while(iter1.hasNext()){
            Map.Entry<String, String> entry = iter1.next();
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
*/





    }

    static int getCapacity(List al) throws Exception {
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        return ((Object[]) field.get(al)).length;
    }

}
