package com.jbksoft.collections.ArrayStringTypeProbs;

public class ReplaceString {

    public static void main(String[] args){

     System.out.println(replaceCharStr(("This is a test").toCharArray(),
    ' ', ("%20").toCharArray()));
    }

    public static String replaceStr(char[] cArray, int cStr, char[]
        cReplace){
        String s="";
        for(int i=cArray.length-1;i>=0;i--){
         if(cArray[i]==cStr){
             for(int j=cReplace.length-1;j>=0;j--){
                 s+=cReplace[j];
             }
         }else{
             s+=cArray[i];
         }
        }

        return reverseStr(s);
    }

    public static String reverseStr(String str){

        int l=0;
        int r=str.length()-1;
        char[] cArray=str.toCharArray();
        while(r>l){
            char temp=cArray[r];
            cArray[r]=cArray[l];
            cArray[l]=temp;
            r--;
            l++;
        }

        return new String(cArray);
    }

    public static String replaceCharStr(char[] cArray,char replace, char[]
        cReplaceArray){

        int spaceCount=0;
        for(int i=0;i<cArray.length;i++){
           if(cArray[i]==replace){
               spaceCount++;
           }
        }

        int counter=cArray.length+(cReplaceArray.length-1)*spaceCount;
        char[] r=new char[counter];
        counter--;

        for(int i=cArray.length-1;i>=0;i--){
            if(cArray[i]==replace){
                for(int j=cReplaceArray.length-1;j>=0;j--){
                  r[counter]=cReplaceArray[j];
                  counter--;
                }

            }else{
                r[counter]=cArray[i];
                counter--;
            }
        }

        return new String(r);
    }


}
