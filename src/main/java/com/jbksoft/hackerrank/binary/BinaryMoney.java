/**
 * In this
 * 2 ==No of iteration
 4 =money
 5 = cost of icecream flavor
 1 4 5 3 2 =list of each cost
 4 =money
 4 = n. of cost flavor
 2 2 4 3
Output:
 1 4 = index of each ice cream taken (1+3)
 1 2
 */
package com.jbksoft.hackerrank.binary;

import java.util.Arrays;
import java.util.Scanner;


    class IceCream implements Comparable<IceCream>{
        int flavor;
        int index;

        public IceCream(int flavor, int index) {
            this.flavor=flavor;
            this.index=index;
        }

        @Override
        public int compareTo(IceCream obj) {
            return (-1)*new Integer(obj.flavor).compareTo(new Integer(this.flavor));
        }

        @Override
        public boolean equals(Object o){
            IceCream i=(o instanceof IceCream)? ((IceCream) o):null;
            if(i!=null){
                return i.flavor == this.flavor && i.index == this.index;
            }

            return false;
        }

    }

    public class BinaryMoney {

        public static int binarySearch(int first, int last, IceCream[] arr, int search) {

            while(first<=last){
               int mid=first+(last-first)/2;
                if(arr[mid].flavor==search){
                    return arr[mid].index;
                }else if(arr[mid].flavor>search){
                    last=mid-1;
                }else{
                    first=mid+1;
                }

            }

            return -1;

        }

        public static void main(String[] args) {

            int t;
            int n, m;

            Scanner in = new Scanner(System.in);
            t = in.nextInt();
            for(int test = 0; test < t; test++) {

                m = in.nextInt();
                n = in.nextInt();
                IceCream[] arr = new IceCream[n];

                for (int i = 0; i < n; i++)
                    arr[i] = new IceCream(in.nextInt(), i + 1);

                Arrays.sort(arr);
                //int firstIndex = 100000, secondIndex = 100000;
                for(int i = 0; i < n - 1 ; i++) {
                    int search = m - arr[i].flavor;
                    if(search >= arr[i].flavor) {
                        int index = binarySearch( i + 1, n - 1, arr, search);
                        if( index != -1 ) {
                            System.out.println( Math.min(arr[i].index, index) + " " + Math.max(arr[i].index, index));
                            break;

                        }
                    }
                }

            }

        }

    }

