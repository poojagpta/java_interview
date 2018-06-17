package com.jbksoft.collections.ArrayStringTypeProbs;

public class RemoveDuplicateString {

    public static void main(String[] args){
        String z="aaaa";
        System.out.println(removeDuplicateString1(z.toCharArray()));
    }

    public static String removeDuplicateString(char[] cArray){

        int bitMask=0x0000;

        for(int i=0;i<cArray.length;i++){
            int r=cArray[i]-97;

            if((bitMask & 1<<r) == 0){
                bitMask = bitMask | 1<<r;
            }else{
                cArray[i]='\0';
            }
        }

        return new String(cArray);
    }

    public static String removeDuplicateString1(char[] cArray){

        for(int i=0;i<cArray.length;i++){
            for(int j=i+1;j<cArray.length;j++){

                if(cArray[i]==cArray[j]){
                    cArray[j]='\0';
                }
            }

        }

        return new String(cArray);
    }

}
