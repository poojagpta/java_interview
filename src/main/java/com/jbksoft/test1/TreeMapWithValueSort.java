package com.jbksoft.test1;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapWithValueSort {
    public static void main(String[] args) {
        Comparator<String> dd=new ss();

        TreeMap<String,TTInteger> tm=new TreeMap<String,TTInteger>(dd);
        TTInteger vv=tm.put("A",new TTInteger(8));

        System.out.println(vv);
        TTInteger initVal=new TTInteger(1);
        TTInteger oldVal=tm.put("A",initVal);

        initVal.increment(oldVal.get());

        System.out.println(tm.get("A"));

    }

    public static class TTInteger{
        private int count;
        public TTInteger(int c){
            count=c;
        }
        public int get(){
            return count;
        }
        public int increment(int a){
            count+=a;
            return count;
        }

        public String toString(){
            return count+"";
        }
    }

    public class cc implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }


    }

    public static class ss implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }


    }


}
