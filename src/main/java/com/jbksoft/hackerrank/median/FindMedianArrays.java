package com.jbksoft.hackerrank.median;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FindMedianArrays {
    public static void main(String[] args) {

    }


    public static void findkth(ArrayList<int[]> arr, int k,int[][] s){
        int greatestArr=0;
        int len=0;
        //Find greatest length array
        for(int i=0;i<arr.size();i++){

            int interlen=s[i][1]-s[i][0];
            if(len<interlen){
                len=interlen;
                greatestArr=i;
            }
        }

        int mid = (s[greatestArr][1]-s[greatestArr][0])/k;
        int midVal=arr.get(greatestArr)[mid];

        int[] position=new int[arr.size()];
         position[greatestArr]=mid;

        for(int i=0;i<arr.size();i++){

            if(!(i==greatestArr)){

                int[] list=arr.get(i);

                int j=0;
                if(j< s[i][1]-1 && midVal>list[j] && midVal<list[j+1]){
                    position[i]=j;
                }
            }
        }

        int sum=0;
        for(int i=0;i<position.length;i++){
            sum+=position[i];
        }

        if(sum>k){
            //Take left
            for(int i=0;i<arr.size();i++){
                s[i][1]=position[i];
            }

        }else if(sum<k){
            //Take right
            k=k-sum;
            for(int i=0;i<arr.size();i++){
                s[i][0]=position[i];
            }
        }
        findkth(arr, k, s);

    }

}
