/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCI;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author chinemeremenumah
 */
public class RansomeNote {
    
    public static boolean checkPossibility(String magazine[], String ransom[]){
        
        Map<String, Integer> mag_map = new HashMap<>();
        Map<String, Integer> note_map = new HashMap<>();
        
        int len_mag = magazine.length;
        for(int i=0; i<len_mag; i++){
            if(mag_map.containsKey(magazine[i])){
                mag_map.replace(magazine[i], mag_map.get(magazine[i])+1);
            } else{
                mag_map.put(magazine[i], 1);
            }
        }
        
        int len_note = ransom.length;
        for(int i=0; i<len_note; i++){
            
            if(!mag_map.containsKey(ransom[i])) {
                return false;
            }
            
            if(note_map.containsKey(ransom[i])){
                note_map.replace(ransom[i], note_map.get(ransom[i])+1);
            } else{
                note_map.put(ransom[i], 1);
            }
            
            if(mag_map.get(ransom[i]) < note_map.get(ransom[i])) { return false; }
        }
            
            
        return true;
    }
            
    public static void main(String[] args) {

        String [] magazine = {"the", "pool", "you", "on"};
        String [] ransom = {"the", "youu", "on"};
        System.out.println(checkPossibility(magazine, ransom));
    }
}
