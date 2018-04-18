package com.jbksoft;

import java.util.Arrays;

public class Coins {

    public static void main(String str[]){
        System.out.println(sumCoinsSeqMatterRecursive(4,new int[]{1,2,3}));
        System.out.println(sumCoinsSeqMatterItertive(4,new int[]{1,2,3}));
        System.out.println(sumCoinsSeqNoMatterRecursive(4, new int[]{1,2,3}));
        System.out.println(sumCoinsSeqNoMatterIterative(4,new int[]{1,2,3}));
    }


    //coin problem where sequence matter and coins is Array 1,2,3,4...
    public static int sumCoinsSeqMatterRecursive(int amount,int[] coins){

        int sum=0;

        if(amount<0){
            return 0;
        }else if(amount==0){
            return 1;
        }

        for(int i=0;i<coins.length;i++){
          sum+= sumCoinsSeqMatterRecursive(amount-coins[i],coins);
        }


        return sum;
    }

    public static int sumCoinsSeqMatterItertive(int amount,int[] coins){
        int[] quan=new int[amount+1];
        quan[0]=1;

        for(int i=1;i<=amount;i++){
           for(int j=0;j<coins.length;j++){
               if(i-coins[j]>=0){
                   quan[i]+=quan[i-coins[j]];
               }
           }


        }

        return quan[amount];
    }

    //coin problem where sequence doesn't matter and coins is Array of 1,2,3....
    public static int sumCoinsSeqNoMatterRecursive(int amount,int[] coins){

        if(amount<0 || coins.length==0){
            return 0;
        }else if(amount==0){
            return 1;
        }


        return sumCoinsSeqNoMatterRecursive(amount-coins[0],coins)+sumCoinsSeqNoMatterRecursive(amount, Arrays.copyOfRange(coins,1,coins.length));
    }



    public static int sumCoinsSeqNoMatterIterative(int amount, int[] coins){

        int[][] quan=new int[amount+1][coins.length+1];


        for(int i=0;i<=coins.length;i++){
            quan[0][i]=1;
        }

        for(int i=1;i<=amount;i++){
          for(int j=0;j<coins.length;j++){

              if(i-coins[j]>=0) {
                  quan[i][j+1] += quan[i - coins[j]][j+1];

              }

              quan[i][j+1] +=quan[i][j];
          }

        }

        return quan[amount][coins.length];
    }
}
