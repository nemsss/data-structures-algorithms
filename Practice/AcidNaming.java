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
public class AcidNaming {
    
    static String acidNaming(String acid_name) {
        
        if(acid_name.substring(0, 5).equals("hydro")){
            if(acid_name.substring(acid_name.length()-2).equals("ic")){
                return "non-metal acid";
            }
            return "polyatomic acid";
        } else{
            return "not an acid";
        }
        
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            for(int a0 = 0; a0 < n; a0++){
                String acid_name = in.next();
                String result = acidNaming(acid_name);
                System.out.println(result);
            }
        }
    }
}
