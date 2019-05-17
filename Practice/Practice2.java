/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Arrays;

/**
 *
 * @author chinemeremenumah
 */
public class Practice2 {
    
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//        int a[] = new int[n];
//        for(int a_i=0; a_i < n; a_i++){
//            a[a_i] = in.nextInt();
//        }

        int ofElements=5; 
        int ofRotations=4; 
        int[]initArray={1,2,3,4,5};
        
        leftRotation(ofElements,ofRotations,initArray);
    }
    
//    private static void leftRotation1(int n, int k, int[] a) {
//        
//        int[] res = new int[n];
//        
//        for(int j=0; j<k; j++){
//            for(int i=0; i<n; i++){
//
//                if(i == n-1){
//                    res[i] = a[0];
//                    break;
//                }
//
//                res[i] = a[i+1];
//
//            }
//            a = res;
//            if(j != k-1){res = new int[n];}           
//           
//            
//        }
//        for(int i=0; i<n; i++) { System.out.print(res[i] + " ");}
//    } 1 2 3 4 5
//      0 1 2 3 4
    
//      4 5 1 2 3
//      3 4 0 1 2    
    
    private static void leftRotation(int n, int k, int[] a) {
        
        int[] res = new int[n];
        
        int shift = k>n? k%n : k;
        for(int i=0; i<n; i++){
             
            int shift_val = (i+shift) >= n ? (i+shift-n) : (i+shift);
            res[i]=a[shift_val];
        }
        
        for(int i=0; i<n; i++) { System.out.print(res[i] + " ");}
        
        
        
    }
}
