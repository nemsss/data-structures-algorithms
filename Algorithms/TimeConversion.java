/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class TimeConversion {
    
    static String timeConversion(String s) {
        
        //12:00:00PM
        //12:00:00
        boolean daytime = "AM".equals(s.substring(8));
        
        int hr = Integer.valueOf(s.substring(0, 2));
        hr = daytime || !daytime&&hr==12? hr : hr+12;
        hr = hr==24 || hr==12&&daytime ? 0 : hr;
        
        String hour = hr<10? "0"+String.valueOf(hr) :String.valueOf(hr);
        
        String min = s.substring(3, 5);
        String sec = s.substring(6, 8);
        
        return(hour+":"+min+":"+sec);
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
