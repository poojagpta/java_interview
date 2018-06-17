package com.jbksoft.collections.ArrayStringTypeProbs;
import java.util.Arrays;

public class reverseCString {
    public static void main(String[] args){

        String str="Thisis testa";
        System.out.println(reverseCString(str.toCharArray()));
    }

    public static String reverseCString(char[] cArray){

        int l=0;
        int r=cArray.length-1;

        while(r>l){
            char tmp=cArray[r];
            cArray[r]=cArray[l];
            cArray[l]=tmp;
            r--;
            l++;
        }

        return new String(cArray);
    }

}
