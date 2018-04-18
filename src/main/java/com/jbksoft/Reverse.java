package com.jbksoft;

import java.util.Arrays;
import java.util.Scanner;

public class Reverse {
    public static void main(String args[]){

        Scanner scanner=new Scanner(System.in);
        char[] charArray=scanner.next().toCharArray();
        int value=scanner.nextInt();
        String rev=reverseString3(charArray,0,charArray.length);

        System.out.println(rev);

        value=reverseInt1(value,String.valueOf(value).length());
        System.out.println(value);

        value=reverseInt2(value);
        System.out.println(value);
    }

    public static int reverseInt1(int val,int n){

          if(val/10==0){
              return val;
          }

       return (val%10)*((int)Math.pow(10,n-1))+reverseInt1(val/10,String.valueOf(val/10).length()-1);
    }

    public static int reverseInt2(int val){

        int reverse=0;
        while(val/10!=0){
            reverse=reverse*10+val%10;
            val=val/10;
        }

        reverse=reverse*10+val%10;

        return reverse;
    }

    public static String reverseString1(String str){
        StringBuilder interm=new StringBuilder();
        for(int i=str.length()-1;i>=0;i--){
            interm.append(str.charAt(i));
        }
        return interm.toString();
    }

    public static String reverseString2(String str){

       StringBuilder interm=new StringBuilder(str);
       int range;
       if(interm.length()%2==0){
           range=interm.length()/2;
       }else{
           range=(interm.length()+1)/2;
       }

       int j=interm.length()-1;
       for(int i=0;i<=range;i++){
        if(j>i){
            char s=interm.charAt(i);
            interm.setCharAt(i, interm.charAt(j));
            interm.setCharAt(j,s);
            j--;
        }
       }

        return interm.toString();
    }

    public static String reverseString3(char[] charArray, int start, int end){

      if(start==end){
           return "";
       } else if(end-start==1){
          return charArray[start]+"";
      }else{
            return charArray[end-1]+reverseString3(charArray,start+1,end-1)+charArray[start];
        }
    }

}
