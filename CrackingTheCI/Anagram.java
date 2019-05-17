/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCI;

/**
 *
 * @author chinemeremenumah
 */
public class Anagram {
    
    public static int numberNeeded(String first, String second) {
      
        StringBuilder w1 = new StringBuilder(first);
        StringBuilder w2 = new StringBuilder(second);
        
        int loops = first.length();
        
        for(int i=0; i<loops; i++){
            
            String s = String.valueOf(first.charAt(i));
            int idx_1 = w1.indexOf(s); 
            int idx_2 = w2.indexOf(s);
            
            if(idx_1 >= 0 && idx_2 >= 0){
                w1.deleteCharAt(idx_1);
                w2.deleteCharAt(idx_2);
            }
        }
            
        return w1.length() + w2.length();
    }
  
    public static void main(String[] args) {

        System.out.println(numberNeeded("cde", "abc"));
    }
}
