package com.jbksoft.collections.ArrayStringTypeProbs;

public class UniqueElementinString {

    public static void main(String[] args){
       String s="abcaa";
        System.out.println(UniqueChar1(s));


    }

    public static boolean UniqueChar(String s){

        boolean[] cArray=new boolean[256];

        for(char c: s.toCharArray()){
            if(cArray[c]){
                return false;
            }else{
                cArray[c]=true;
            }
        }

        return true;
    }

    public static boolean UniqueChar1(String s){

        int status=0x0000;

        for(char c: s.toLowerCase().toCharArray()){
            int a=c-97;
            if((status & 1<<a)==0){
                status = status|1<<a;
            } else {
                return false;
            }
        }
        return true;
    }
}
