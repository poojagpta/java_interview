package com.jbksoft.Palindrome;

import java.util.ArrayList;

public class MancherAlgo {

    // abcdcbabcdabcddcba

    public static void main(String[] args) {
        ArrayList s=new ArrayList();

     String str="abaxabaxabybaxabyb";
        System.out.println(findLongestPalindromSubString1(str.toCharArray()));
    }

    @Override
    public boolean equals(Object b){
     return true;
    }

    public static String findLongestPalindromSubString1(char[] chArray){
        int[] buffer=new int[chArray.length];
        int c=0,r=0;

        for(int i=1;i<chArray.length;i++){
          int mirror=2*c-i;

          if(mirror>0 ){ // i < r

              buffer[i]=Math.min(r-i,buffer[mirror]);
          }


          while(i-(buffer[i]+1)>=0 && i+(buffer[i]+1)<chArray.length-1 && chArray[i-(buffer[i]+1)]==chArray[i+(buffer[i]+1)]){//
              buffer[i]++;
          }

          if((buffer[i]+i)>r){
              c=i;
              r=i+buffer[i];
          }

        }

        int max=0;
        int position=0;
        for(int i=1;i<buffer.length;i++){
            if(buffer[i]>max){
                max=buffer[i];
                position=i;
            }
        }

        String s  = new String(chArray);


        return s.substring(position-max,position)+ s.substring(position,position+max+1);
    }

    public static int findLongestPalindromSubString(char[] chArray){
        int[] buffer=new int[chArray.length];
        int maxSize=0;
        int position=1;
        while(position<chArray.length){
            position=findCenter(position, buffer,maxSize,chArray);
            if(position>0){
                int countMatch=findPalindrom(position, chArray);
                buffer[position]=countMatch;
                if(countMatch>maxSize){
                    maxSize=countMatch;
                }
            }else{
                position=chArray.length;
            }

            position=position+1;
        }
        return maxSize;
    }

    public static int findPalindrom(int position, char[] chArray){
        int counter=0;
        boolean isMatch=true;
        while(isMatch && position-counter>=0 && position+counter<chArray.length){
            if(chArray[position-counter]==chArray[position+counter]){
                counter=counter+1;
            }else{
                counter=counter-1;
                isMatch=false;
            }
        }

        return counter*2+1;
    }



    public static int findCenter(int position,int[] buffer,int maxSize, char[] chArray){
        if(position<3){
            return position;
        }else if(position>=chArray.length-1){
            return -1;
        }else{
            int maxLength=(maxSize-1)/2;
            //Checking the boundary of the palindrome if greater
            if(position-maxLength>=0 && position+maxLength<chArray.length && chArray[position-maxLength]==chArray[position+maxLength]){
                return position;
            }else{
                return findCenter(position+1,buffer,maxSize, chArray);
            }
        }
    }
}
