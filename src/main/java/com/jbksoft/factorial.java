package com.jbksoft;

public class factorial {
    public static void main(String args[]){
        if(args.length<0){
            System.out.println("Please enter number argument");
            System.exit(0);
        }

        int number=0;
        try{
            number= Integer.valueOf(args[0]);
        }catch (Exception ex){
            System.out.println("Please enter valid number");
            System.exit(0);
        }

        if(number>=0){
            int fact=factorial1(number);
            System.out.println(fact);
        }


    }
    public static int factorial(int number){
        if(number<=0){
            return 1;
        }else{
            return number*factorial(number-1);
        }
    }

    public static int factorial1(int number){
        int factorialNumber=1;
        for(int i=number;i>=0;i--){
            if(i==0){
                factorialNumber*=1;
            }else{
                factorialNumber*=i;
            }

        }
        return factorialNumber;
    }
}
