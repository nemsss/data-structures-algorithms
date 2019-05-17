/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class GiveACheck {
    
    static int waysToGiveACheck(char[][] board) {
        // Complete this function
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            char[][] board = new char[8][8];
            for(int board_i = 0; board_i < 8; board_i++){
              String input = in.next();
                for(int board_j = 0; board_j < 8; board_j++){
                    board[board_i][board_j] = input.charAt(board_j);
                }
            }
            int result = waysToGiveACheck(board);
            System.out.println(result);
        }
        in.close();
        
    }
}
