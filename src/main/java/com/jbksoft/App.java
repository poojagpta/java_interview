package com.jbksoft;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*System.out.println( "Hello World!" );
        double range=Math.sqrt(11);
        isWhilework();
        System.out.println(range);

        String s="abcd ee tt gg";
        String[] strs=s.split("\\s+");
        for(int i=0;i<strs.length;i++){
            System.out.println(strs[i]);
        }

        HashMap<String,Integer> map=new HashMap<String,Integer>();
        int val=map.get("Test");
        val=val+1;*/

        HashSet s=new HashSet();
        System.out.println(s.add(1));
        System.out.println(s.add(1));

    }

    public int sumCoins(int amount, int[] coins){
        if(amount<0 || coins.length<=0){
            return 0;
        }else if(amount==0){
            return 1;
        }

        return sumCoins(amount-coins[0],coins)+sumCoins(amount, Arrays.copyOfRange(coins,1,coins.length));

    }


    public static boolean isWhilework(){
        boolean isTrue=true;
        while(isTrue){
            isTrue=false;
            System.out.println("I am here");
            return isTrue;
        }
        return isTrue;
    }
}
