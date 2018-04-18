package com.jbksoft;

/**
 * Get the Number.
 * If
 */
public class primeNumber {

    public static void main(String args[]){
        if(args.length<1){
            System.out.println("Please specify the number as first argument");
            System.exit(0);
        }

        int number=0;

        try{
          number=Integer.valueOf(args[0]);
         }catch (NumberFormatException ex){
            System.out.println("Please specify the number as first argument");
            System.exit(0);
         }

      if(number>0){

          boolean isPrime=isPrimeNumber3(number);
          if(isPrime){
              System.out.println(number+" is a prime number !!!");
          }else{
              System.out.println(number+" is not prime number !!!");
          }
      }
    }

    public static boolean isPrimeNumber1(int number){
        if(number==1 || number==2 || number==3){
            return true;
        }else{
            if((number*number -1) %24==0){
                return true;
            }else{
                return false;
            }
        }
    }

    public static boolean isPrimeNumber2(int number){
        if(number==1 || number==2 || number==3){
            return true;
        }else {
            int range = ((int) Math.sqrt(number)) + 1;
            for (int i = 2; i <= range; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean isPrimeNumber3(int number){
        if(number==1 || number==2 || number==3){
            return true;
        }else {
                for (int i = 2; i <= number-1; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
