package com.jbksoft.collections.ArrayStringTypeProbs;

public class AnagramString {

    public static void main(String[] args){

        System.out.println(isAnagram("abc".toCharArray(),"ddc".toCharArray()));
        System.out.println(isAnagram1("abc".toCharArray(),"ddc".toCharArray()));
    }

    public static boolean isAnagram(char[] str1, char[] str2){

        if(str1==null || str2==null) return false;
        if(str1.length!=str2.length) return false;

        for(int i=0;i<str1.length;i++){

            char a=str1[i];
            boolean flag=false;
            for(int j=0;j<str2.length;j++){
                if(str2[j]==a){
                    str2[j]='\0';
                   flag=true;
                }
            }

            if(!flag){
                return false;
            }

        }

        return true;
    }


    public static boolean isAnagram1(char[] str1, char[] str2){

        if(str1==null || str2==null) return false;
        if(str1.length!=str2.length) return false;

        int[] ascii=new int[256];
        for(int i=0;i<str1.length;i++){
            ascii[str1[i]]++;
        }

        for(int i=0;i<str2.length;i++){
            if(ascii[str2[i]]>0){
                ascii[str2[i]]--;
            }else{
                return false;
            }
        }
        return true;
    }

}
