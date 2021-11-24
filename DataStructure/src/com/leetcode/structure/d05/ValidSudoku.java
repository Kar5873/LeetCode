package com.leetcode.structure.d05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kar
 * @create 2021-11-24 下午4:02
 */
public class ValidSudoku {


    public boolean isValidSudoku(char[][] board) {
        // for (int i = 1; i <= 9; i++) {
        //     map.put(i + "", "");
        // }
        int length = board.length;
        for (int i = 0; i < length; i++) {
            HashMap<Character, Character> map = new HashMap<>();
            for (int j = 0; j < length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!map.containsKey(board[i][j])) {
                    map.put(board[i][j], ' ');
                } else {
                    return false;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            HashMap<Character, Character> map = new HashMap<>();
            for (int j = 0; j < length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (!map.containsKey(board[j][i])) {
                    map.put(board[j][i], ' ');
                } else {
                    return false;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            HashMap<Character, Character> map = new HashMap<>();
            for (int j = 0; j < length; j++) {
                if(i/3 == j/3){
                    if (board[j][i] == '.') {
                        continue;
                    }
                    if (!map.containsKey(board[j][i])) {
                        map.put(board[j][i], ' ');
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }



}
