package com.jbksoft.Palindrome;

public class DPLongestPalidrome {

    public static void main(String[] args) {

        int x=1;

        for(int i=0;i<3;i++){
            x+=5*i;
        }

        System.out.println(x);
        //System.out.println(getLargestPalindrome("abaxabaxabybaxabyb"));
    }

    public static int getLargestPalindrome(String str){
        Node[][] arr=new Node[str.length()][str.length()];

        for(int i=0;i<str.length();i++){
            arr[i][i]=new Node(1,true);
        }

        for(int d=1;d<=str.length();d++){
            for(int i=0;i<str.length()-d;i++){
             int j=i+d;

             if(str.charAt(i)==str.charAt(j) && d==1){
               arr[i][j]=new Node(2,true);
             }else if(str.charAt(i)==str.charAt(j) && arr[i+1][j-1].isMatch){
                    arr[i][j]=new Node(arr[i+1][j-1].getData()+2,true);
             }else{
                  arr[i][j]=new Node(Math.max(arr[i+1][j].getData(),arr[i][j-1].getData()),false);
              }

            }
        }

        return arr[0][str.length()-1].getData();
    }

    static class Node{
        int data;
        boolean isMatch;
        Node(int data, boolean isMatch){
            this.data=data;
            this.isMatch=isMatch;
        }

        public int getData(){
            return data;
        }

        public boolean isMatch(){
            return isMatch;
        }
    }

    static int max (int x, int y) { return (x > y)? x : y; }

    // Returns the length of the longest palindromic subsequence in seq
    static int lps(String seq)
    {
        int n = seq.length();
        int i, j, cl;
        int L[][] = new int[n][n];  // Create a table to store results of subproblems

        // Strings of length 1 are palindrome of lentgh 1
        for (i = 0; i < n; i++)
            L[i][i] = 1;

        // Build the table. Note that the lower diagonal values of table are
        // useless and not filled in the process. The values are filled in a
        // manner similar to Matrix Chain Multiplication DP solution (See
        // https://www.geeksforgeeks.org/archives/15553). cl is length of
        // substring
        for (cl=2; cl<=n; cl++)
        {
            for (i=0; i<n-cl+1; i++)
            {
                j = i+cl-1;
                if (seq.charAt(i) == seq.charAt(j) && cl == 2)
                    L[i][j] = 2;
                else if (seq.charAt(i) == seq.charAt(j))
                    L[i][j] = L[i+1][j-1] + 2;
                else
                    L[i][j] = max(L[i][j-1], L[i+1][j]);
            }
        }

        return L[0][n-1];
    }

}
