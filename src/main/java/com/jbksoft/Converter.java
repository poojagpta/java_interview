package com.jbksoft;

import java.util.Arrays;

public class Converter {
    public static void main(String[] args) {
      //  System.out.println(Math.pow(-1,2));
        //System.out.println(getConverted(13,-2));
        System.out.println(getConverted(13,-2));
        System.out.println(getConvertedNegative(13,-2));
    }

    public static String getConverted(int amount, int rate){
        StringBuffer s=new StringBuffer();
//        int count=0;

        int r = rate;

        while(amount!=0){



            /*if(r<0){
                r= Math.abs(r) * (int) Math.pow(-1,count);
                count++;
            }
*/
//            int n = Math.abs(amount % r);
//
//            amount=amount / r;

            int n = amount % r;

            amount=amount / r;

            System.out.println("-->"+amount+" : "+n);

            //–5 ÷ –3 must be chosen to equal 2 remainder 1 instead of 1 remainder –2.
            // -3*2+1 = 5 as well -3*1+(-2)
            if (n < 0)
            {
                n += 2;
                amount += 1;
            }
            s.append(n);
            System.out.println(amount+" : "+n);
        }


        return s.reverse().toString();
    }

   public static String getConvertedNegative(int amount, int rate){
        int[] arr=new int[5];

        for(int i=0;i<5;i++){
            arr[i]= (int)Math.pow(rate,i);
        }

        StringBuffer s=new StringBuffer();
        if (getTotal(amount, arr,"")){
            return curSel;
        }

       return "Not";
   }

   public static String curSel="";

   public static boolean getTotal(int amount,int[] arr,  String currSel){

       if(amount == 0){
          curSel=currSel;
          return true;
      }else if(amount<0 || arr.length<=0){
           return false;
       }

     return getTotal(amount-arr[0], Arrays.copyOfRange(arr,1,arr.length),currSel+"1") ||
             getTotal(amount, Arrays.copyOfRange(arr,1,arr.length),currSel+"0");

   }




 }
