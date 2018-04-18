package com.jbksoft;

import java.util.*;

public class ArrayString {

public static void main(String[] args){
    /*String result=removeDuplicateCharWithMemory("aaabbb");
    System.out.println(result);
*/
  /*  boolean isAnagram=isAnagram2("LISTEN","SILENT");
    System.out.println(isAnagram);*/


    int[][] matrix=new int[4][4];

    matrix[0][0]=0;
    matrix[0][1]=1;
    matrix[0][2]=2;
    matrix[0][3]=3;
    matrix[1][0]=4;
    matrix[1][1]=5;
    matrix[1][2]=6;
    matrix[1][3]=7;
    matrix[2][0]=8;
    matrix[2][1]=9;
    matrix[2][2]=10;
    matrix[2][3]=11;
    matrix[3][0]=12;
    matrix[3][1]=13;
    matrix[3][2]=14;
    matrix[3][3]=15;

    rotateMatrix(matrix,4);

     for(int i=0;i<4;i++){
         for(int j=0;j<4;j++){
             System.out.print(matrix[i][j]+" ");
         }

         System.out.println("--------");
     }

   // LinkedList<String> linkedList=new LinkedList<String>();
   // linkedList.add("T");


}

    public static void rotateMatrix(int[][] matrix, int n){
        for(int i=0;i<n/2;i++) {
            int first = i;
            int last=n-1-i;
            for (int j = 0; j < last; j++) {

                int temp1 = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = matrix[i][j];

                int temp2 = matrix[n - i - 1][n - i - 1];
                matrix[n - i - 1][n - j - 1] = temp1;

                int temp3 = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp2;

                matrix[i][j] = temp3;

            }
        }
    }

    public static void rotate(int[][] matrix, int n) {

        for (int layer = 0; layer < n / 2; ++layer) {

            int first = layer;

            int last = n - 1 - layer;

            for(int i = first; i < last; ++i) {

                int offset = i - first;

                int top = matrix[first][i]; // save top

// left -> top

                matrix[first][i] = matrix[last-offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];



            }

        }
    } // top -> right


    public static boolean isAnagram2(String str1,String str2 ){
        if(str1==null || str2==null) return false;
        if(str1.length()!=str2.length()) return false;
        char[] arrStr1=str1.toCharArray();
        char[] arrStr2=str2.toCharArray();

        for(int i=0;i<arrStr1.length;i++){
            boolean match =false;
            for(int j=0;j<arrStr2.length;j++){
                if(arrStr1[i]==arrStr2[j]){
                    arrStr2[j]='\0';
                    match=true;
                }
            }

            if(!match) return false;
        }

        return true;
    }

    public static boolean isAnagram(String str1,String str2 ){

        int[] char_set=new int[256];

        for(int i=0;i<str1.length();i++){
            char_set[str1.charAt(i)]++;
        }

        for(int i=0;i<str2.length();i++){
            int pos=str2.charAt(i);
            if(char_set[pos]==0) return false;
            char_set[pos]--;
        }
        return true;
    }

    public static String removeDuplicateCharWithMemory(String str){
        if (str==null) return str;
        char[] char_set=new char[256];

        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            char_set[c]=c;
        }

        return Arrays.toString(char_set);
    }

    public static String removeDuplicateChar(String str){
    if(str==null) return str;

    char[] arrStr=str.toCharArray();

        for(int i=1;i<arrStr.length;i++){
            for(int j=0;j<i;j++){
                if(arrStr[i]==arrStr[j]){
                    arrStr[i]='\0';
                    break;
                }
            }
        }

        return new String(arrStr);
    }
    public static String reverse(String str){
        char[] arrStr=str.toCharArray();
        int i=0,j=arrStr.length-1;
        while(i<j){
            char temp=arrStr[i];
            arrStr[i]=arrStr[j];
            arrStr[j]=temp;
            i++;
            j--;
        }

        return Arrays.toString(arrStr);
    }

    public static boolean isUnique(String val){

        boolean[] char_set=new boolean[256];

        for(int i=0;i<val.length();i++){
            int ch=val.charAt(i);
            if(char_set[ch]) return false;
            char_set[ch]=true;
        }

        return true;
    }

    public static boolean isDuplicateWithoutDataStructure(char[] chArray){

      int count=0;
      boolean isDuplicate=false;
      while(count<chArray.length){
          for(int i=0;i<chArray.length;i++){
              if(i!=count && chArray[count]==chArray[i]){
                  isDuplicate=true;
                  break;
              }
          }
          count++;
          if(isDuplicate){
              return isDuplicate;
          }
      }

       return false;
    }

}
