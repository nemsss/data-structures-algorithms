/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HourRank;

import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class StrongPassword {
    
        
    static int minimumNumber(int n, String password) {
        
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";
    
        int num = 0;
        int lower = 0;
        int upper = 0;
        int special = 0;
        
        for(int i=0; i<n; i++){
            if(numbers.indexOf(password.charAt(i)) != -1) num+= 1;
            else if(lower_case.indexOf(password.charAt(i)) != -1) lower+= 1;
            else if(upper_case.indexOf(password.charAt(i)) != -1) upper+= 1;
            else if(special_characters.indexOf(password.charAt(i)) != -1) special+= 1;
            
//            System.out.println(num +" "+lower+" "+upper+" "+special);
        }
        
        int needed = 0;

        if(num == 0) needed+= 1;
        if(lower == 0) needed+= 1;
        if(upper == 0) needed+= 1;
        if(special == 0) needed+= 1;
        
        while((needed + n) < 6) needed += 1;
//        System.out.println(needed);
        return needed;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        String password = in.next();
        int answer = minimumNumber(11, "#Hackerrank");
        System.out.println(answer);
//        in.close();
    }
}
