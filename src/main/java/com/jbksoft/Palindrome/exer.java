package com.jbksoft.Palindrome;

import java.util.ArrayList;
import java.util.Arrays;

public class exer {
    public static void main(String[] args) {
        String dictionary[] = {"hit", "hits", "kilts", "pEg","peN","pentAgon","slit","slits","sTilts"};

        char boggle[][] = {{'P','W','Y','R'},
                {'E','N','T','H'},
                {'G','S','I','Q'},
                {'O','L','S','A'}
        };



        System.out.println(Arrays.toString(findWords(boggle, dictionary)));
    }

    static String[] findWords(char[][] board, String[] dictionary) {
        ArrayList<String> result = new ArrayList();
        WordNode root = new WordNode();
        for (String s : dictionary) {
            insert(root, s.toLowerCase());
        }

        WordNode tmp = root;

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = Character.toLowerCase(board[i][j]);
                int index = c - 'a';
                if (tmp.child[index] != null) {
                    // traverse it
                    get(tmp.child[index], board, i, j, visited, "", result);
                }
            }
        }
        return result.toArray(new String[]{});
    }

    static boolean isSafe(int i, int j, boolean visited[][], char[][] board) {
        return (i >= 0 && i < board.length && j >= 0 &&
                j < board[0].length && !visited[i][j]);
    }

    static void get(WordNode node, char[][] board, int i, int j, boolean[][] visited, String str, ArrayList<String> result) {
        if (node.isWord == true)
            result.add(str);

        if (i >= 0 && i < board.length && j >= 0 &&
                j < board[0].length && !visited[i][j]) {
            visited[i][j] = true;

            for (int K = 0; K < 26; K++) {
                if (node.child[K] != null) {

                    char ch = (char) (K + 'a');

                    System.out.println(ch+" "+i);

                    if (isSafe(i + 1, j + 1, visited, board) && Character.toLowerCase(board[i + 1][j + 1])
                            == ch)
                        get(node.child[K], board, i + 1, j + 1,
                                visited, str + ch, result);
                    if (isSafe(i, j + 1, visited, board) && Character.toLowerCase(board[i][j + 1])
                            == ch)
                        get(node.child[K], board, i, j + 1,
                                visited, str + ch, result);
                    if (isSafe(i - 1, j + 1, visited, board) && Character.toLowerCase(board[i - 1][j + 1])
                            == ch)
                        get(node.child[K], board, i - 1, j + 1,
                                visited, str + ch, result);
                    if (isSafe(i + 1, j, visited, board) && Character.toLowerCase(board[i + 1][j])
                            == ch)
                        get(node.child[K], board, i + 1, j,
                                visited, str + ch, result);
                    if (isSafe(i + 1, j - 1, visited, board) && Character.toLowerCase(board[i + 1][j - 1])
                            == ch)
                        get(node.child[K], board, i + 1, j - 1,
                                visited, str + ch, result);
                    if (isSafe(i, j - 1, visited, board) && Character.toLowerCase(board[i][j - 1])
                            == ch)
                        get(node.child[K], board, i, j - 1,
                                visited, str + ch, result);
                    if (isSafe(i - 1, j - 1, visited, board) && Character.toLowerCase(board[i - 1][j - 1])
                            == ch)
                        get(node.child[K], board, i - 1, j - 1,
                                visited, str + ch, result);
                    if (isSafe(i - 1, j, visited, board) && Character.toLowerCase(board[i - 1][j])
                            == ch)
                        get(node.child[K], board, i - 1, j,
                                visited, str + ch, result);
                }
            }

            visited[i][j] = false;
        }
    }

    static void insert(WordNode root, String s) {
        WordNode tmp = root;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if (tmp.child[index] == null)
                tmp.child[index] = new WordNode();
            tmp = tmp.child[index];
        }
        tmp.isWord = true;
    }

    static class WordNode {
        boolean isWord;
        WordNode[] child = new WordNode[26];

        public WordNode() {
            for (int i = 0; i < 26; i++)
                child[i] = null;
        }
    }
}
