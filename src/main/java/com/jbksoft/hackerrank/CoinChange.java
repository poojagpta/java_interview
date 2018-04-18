package com.jbksoft.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoinChange {
    public static int MIN_COIN_VAL=Integer.MAX_VALUE;

    public static boolean minCoinUtil(int[] coins, int money, int coinCount){
       if(coins.length<=0 || money<0){
           return false;
       }else if(money==0){
           if(coinCount<MIN_COIN_VAL){
               MIN_COIN_VAL=coinCount;
           }
           return true;
       }

       return minCoinUtil(coins,money-coins[0],coinCount+1) ||
               minCoinUtil(Arrays.copyOfRange(coins,1,coins.length),money,coinCount);
    }

    public static boolean minCoinUtil2(int[] coins, int money, int coinCount){
        if(coinCount>=coins.length || money<0){
            return false;
        }else if(money==0){
            if(coinCount<MIN_COIN_VAL){
                MIN_COIN_VAL=coinCount;
            }
            return true;
        }

        for(int i=coinCount;i<coins.length;i++){
            boolean result=minCoinUtil2(coins,money-coins[i],coinCount+1);
            return result;
        }

        return false;
    }

    public static int minCoins(int[] coins,int money){
        if(minCoinUtil2(coins,money,0)){
            return MIN_COIN_VAL;
        }else{
            return -1;
        }

    }




    public static long makeChange(int[] coins, int money) {
        /*if(money<0 || coins.length<=0){
            return 0;
        }else if(money==0){
            return 1;
        }else{
            //Assuming coin is alwad present, Coin never present
            return makeChange(coins,money-coins[0],matrix) + makeChange(Arrays.copyOfRange(coins,1,coins.length),money,matrix);
        }*/


            long[][] coinChangeMatrix=new long[coins.length+1][money+1];

            for(int i=0;i<coins.length+1;i++)
                coinChangeMatrix[i][0]=1;

            //Coins ->rows,Money->column
            for(int i=1;i<coins.length+1;i++)
            for(int j=1;j<money+1;j++){
                //If coins is present
                long x=0;
                if(j-coins[i-1]>=0){
                    x=coinChangeMatrix[i][j-coins[i-1]];
                }else{
                    x=0;
                }

                //If coins not present
                long y=0;
                if(i-1>0){
                    y=coinChangeMatrix[i-1][j];
                }else{
                    y=0;
                }

                coinChangeMatrix[i][j]=x+y;
            }



            return coinChangeMatrix[coins.length][money];
        }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
       // Arrays.sort(coins);
        System.out.println(minCoins(coins, n));
    }
}

