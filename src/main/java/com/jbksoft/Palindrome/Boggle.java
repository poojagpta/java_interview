package com.jbksoft.Palindrome;

import com.jbksoft.ArrayStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boggle {
//
//    // Alphabet size
//    static final int SIZE = 26;
//
//    static final int M = 4;
//    static final int N = 4;



    // trie Node
//    static class TrieNode
//    {
//        TrieNode[] Child = new TrieNode[SIZE];
//
//        // isLeaf is true if the node represents
//        // end of a word
//        boolean leaf;
//
//        //constructor
//        public TrieNode() {
//            leaf = false;
//            for (int i =0 ; i< SIZE ; i++)
//                Child[i] = null;
//        }
//    }

    static class WordNode {
        boolean isWord;
        WordNode[] child = new WordNode[26];

        public WordNode() {
            for (int i = 0; i < 26; i++)
                child[i] = null;
        }
    }

    // If not present, inserts key into trie
    // If the key is prefix of trie node, just
    // marks leaf node
    static void insert(WordNode root, String Key)
    {
        int n = Key.length();
        WordNode pChild = root;

        for (int i=0; i<n; i++)
        {
            int index = Key.charAt(i) - 'a';

            if (pChild.child[index] == null)
                pChild.child[index] = new WordNode();

            pChild = pChild.child[index];
        }

        // make last node as leaf node
        pChild.isWord = true;
    }

    // function to check that current location
    // (i and j) is in matrix range
    static boolean isSafe(int i, int j, boolean visited[][], char boggle[][])
    {
        return (i >=0 && i < boggle.length && j >=0 &&
                j < boggle[0].length && !visited[i][j]);
    }


    // A recursive function to print all words present on boggle
    static void searchWord(WordNode root, char boggle[][], int i,
                           int j, boolean visited[][], String str, ArrayList<String> elements)
    {

        // if we found word in trie / dictionary
        if (root.isWord == true){
//            System.out.println(str.toString());
            elements.add(str.toString());
        }


        // If both I and j in  range and we visited
        // that element of matrix first time
        if (isSafe(i, j, visited,boggle))
        {
            // make it visited
            visited[i][j] = true;

            // traverse all child of current root
            for (int K =0; K < 26; K++)
            {
                if (root.child[K] != null)
                {
                    // current character
                    char ch = (char) (K + 'a') ;

                    // Recursively search reaming character of word
                    // in trie for all 8 adjacent cells of
                    // boggle[i][j]
                    if (isSafe(i+1,j+1,visited,boggle) && Character.toLowerCase(boggle[i+1][j+1])
                            == ch)
                        searchWord(root.child[K],boggle,i+1,j+1,
                                visited,str+ch, elements);
                    if (isSafe(i, j+1,visited,boggle)  && Character.toLowerCase(boggle[i][j+1])
                            == ch)
                        searchWord(root.child[K],boggle,i, j+1,
                                visited,str+ch, elements);
                    if (isSafe(i-1,j+1,visited,boggle) && Character.toLowerCase(boggle[i-1][j+1])
                            == ch)
                        searchWord(root.child[K],boggle,i-1, j+1,
                                visited,str+ch, elements);
                    if (isSafe(i+1,j, visited,boggle)  && Character.toLowerCase(boggle[i+1][j])
                            == ch)
                        searchWord(root.child[K],boggle,i+1, j,
                                visited,str+ch, elements);
                    if (isSafe(i+1,j-1,visited,boggle) && Character.toLowerCase(boggle[i+1][j-1])
                            == ch)
                        searchWord(root.child[K],boggle,i+1, j-1,
                                visited,str+ch, elements);
                    if (isSafe(i, j-1,visited,boggle)&& Character.toLowerCase(boggle[i][j-1])
                            == ch)
                        searchWord(root.child[K],boggle,i,j-1,
                                visited,str+ch, elements);
                    if (isSafe(i-1,j-1,visited,boggle) && Character.toLowerCase(boggle[i-1][j-1])
                            == ch)
                        searchWord(root.child[K],boggle,i-1, j-1,
                                visited,str+ch, elements);
                    if (isSafe(i-1, j,visited,boggle) && Character.toLowerCase(boggle[i-1][j])
                            == ch)
                        searchWord(root.child[K],boggle,i-1, j,
                                visited,str+ch, elements);
                }
            }

            // make current element unvisited
            visited[i][j] = false;
        }
    }

    // Prints all words present in dictionary.
    static ArrayList<String> findWords(char boggle[][], WordNode root)
    {
        // Mark all characters as not visited
        boolean[][] visited = new boolean[boggle.length][boggle[0].length];
        WordNode pChild = root ;

        String str = "";
        ArrayList<String> list=new ArrayList<String>();

        // traverse all matrix elements
        for (int i = 0 ; i < boggle.length; i++)
        {
            for (int j = 0 ; j < boggle[0].length ; j++)
            {
                // we start searching for word in dictionary
                // if we found a character which is child
                // of Trie root
                if (pChild.child[(Character.toLowerCase(boggle[i][j])) - 'a'] != null)
                {
                    str = str+Character.toLowerCase(boggle[i][j]);

                    //String word=str;

                    searchWord(pChild.child[(Character.toLowerCase(boggle[i][j])) - 'a'],
                                boggle, i, j, visited, str, list);


                    str = "";
                }
            }
        }
        return list;
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        // Let the given dictionary be following
        String dictionary[] = {"hit", "hits", "kilts", "pEg","peN","pentAgon","slit","slits","sTilts"};



        char boggle[][] = {{'P','W','Y','R'},
                {'E','N','T','H'},
                {'G','S','I','Q'},
                {'O','L','S','A'}
        };

        String[] val=findWords(boggle,dictionary);

        System.out.println(Arrays.toString(val));


    }

    static String[] findWords(char[][] board, String[] dictionary){

        int row=board.length;
        int column=board[0].length;

        // root Node of trie
        WordNode root = new WordNode();

        // insert all words of dictionary into trie
        int n = dictionary.length;
        for (int i=0; i<n; i++)
            insert(root, dictionary[i].toLowerCase());

       ArrayList<String> elements  = findWords(board, root);

        return elements.toArray(new String[elements.size()]);
    }
}
// This code is contributed by Sumit Ghosh
