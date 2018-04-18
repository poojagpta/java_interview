package com.jbksoft;

import java.util.Scanner;

/**
 * Java is pass reference object to method by value.
 * Therefore any change in reference value not reflected but also
 * Java Change object by reference so changes inside the object is reflected.
 *
 *
 */
public class SwapNumber {
    public static void main(String args[]){

       /* if(args.length<2){
            System.out.println("Please specify 2 argument to swap");
            System.exit(0);
        }

        int x=Integer.parseInt(args[0]);
        int y=Integer.parseInt(args[1]);*/

        Scanner scanner = new Scanner(System.in);
        Integer x = scanner.nextInt();
        Integer y = scanner.nextInt();

        //Method 1:
       /* x=x+y;
        y=x-y;
        x=x-y;*/

        //Method 2:
//        x=x ^ y ^ (y=x);
        swap(x,y);

        System.out.println("Value of x:"+ x +" Value of y:"+ y);

    }

    public static void swap(Integer x, Integer y){
        x=x+y;
        y=x-y;
        x=x-y;
        System.out.println("Value of x---->"+x+" Value of y---->"+y);
    }

}
