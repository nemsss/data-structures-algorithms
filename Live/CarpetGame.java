/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Live;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class CarpetGame {
    
    static int howManyWays(int n, int m, long k) {
        // Return the number of ways modulo 10^9+7.
        return 0;
    }


    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int d = Integer.parseInt(scan.nextLine().trim());

        for (int dItr = 0; dItr < d; dItr++) {
            String[] nmk = scan.nextLine().split(" ");

            int n = Integer.parseInt(nmk[0].trim());

            int m = Integer.parseInt(nmk[1].trim());

            long k = Long.parseLong(nmk[2].trim());

            int result = howManyWays(n, m, k);

            bw.write(String.valueOf(result));
            bw.newLine();
        }

        bw.close();
    }
}
