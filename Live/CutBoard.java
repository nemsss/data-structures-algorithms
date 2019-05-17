/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Live;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class CutBoard {
    
    static void fillBoard(int rows, int cols, int top, int bott) {
        
        if(rows*cols - (top+bott)%2!=0){
            System.out.println("NO");
            return;
        }
        // ---oo
        // ooooo    rows=3,cols=5,  top=3,bott=2
        // ooo--
        
        System.out.println("YES");
        List<char[]> used = new ArrayList<>();

        for(int row=1; row<=rows; row++){
            for(int col=1; col<=cols; col++){
                if((row==1 && col<=top) || (row==rows && col>cols-bott)){
                    continue;
                }
                if(col+1 <= cols){
                    System.out.println(row+" "+col+" "+row+" "+(col+1));
                }
            }
        }
    }


    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nmxy = scan.nextLine().split(" ");

        int n = Integer.parseInt(nmxy[0].trim());

        int m = Integer.parseInt(nmxy[1].trim());

        int x = Integer.parseInt(nmxy[2].trim());

        int y = Integer.parseInt(nmxy[3].trim());

        fillBoard(n, m, x, y);
    }
}
