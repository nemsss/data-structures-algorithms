/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */

class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
    
    String getName(){
        return this.name;
    }
    
    int getScore(){
        return this.score;
    }
}

public class Comparer {
     public static void main(String[] args) {
         Player[] players;
         Checker checker;
         try (Scanner scan = new Scanner(System.in)) {
             int n = scan.nextInt();
             players = new Player[n];
             checker = new Checker();
             for(int i = 0; i < n; i++){
                 players[i] = new Player(scan.next(), scan.nextInt());
             }}

        Arrays.sort(players, checker);
         for (int i = players.length-1; i >=0; i--) {
             System.out.printf("%s %s\n", players[i].name, players[i].score);
         }
    }
}

class Checker implements Comparator<Player>{

    @Override
    public int compare(Player a, Player b) {
        
        if(a.getScore() > b.getScore()){
            return 1;
        } else if (a.getScore() < b.getScore()){
            return -1;
        } else{
            return a.getName().compareTo(b.getName());
        }
    }

    
}
