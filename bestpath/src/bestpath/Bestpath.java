/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bestpath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Salman
 */
public class Bestpath {

    /**
     * @param args the command line arguments
     * 
     */
    public Bestpath(){}
      public static int minimum(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        }
        if (b < a && b < c) {
            return b;
        }
        if (c < a && c < b) {
            return c;
        }
        if (a == b && a < c) {
            return a;
        }
        if (b == c && b < a) {
            return b;
        } else {
            return a;
        }
        
    }
      public static int minicost(int asem1_costs[][], ArrayList<Integer>n1_cost, ArrayList<Integer>n2_cost,ArrayList<Integer>n3_cost,int n) {
       int pp1[];
        pp1 = new int[5];
        int pp2[] = new int[5];
        int pp3[] = new int[5];

        Bestpath obj = new Bestpath();
pp1[0]=5;
pp2[0]=4;
pp3[0]=2;
        for (int i = 1; i < n; i++) {
            
            
            pp1[i] = minimum(pp1[i - 1] + n1_cost.get(i), pp2[i - 1] + asem1_costs[i-1][1]+ n2_cost.get(i), pp3[i - 1] +asem1_costs[i-1][0] + n3_cost.get(i));
           
            pp2[i] = minimum(pp2[i - 1] + n2_cost.get(i), pp1[i - 1] + asem1_costs[i-1][1] + n2_cost.get(i), pp3[i - 1] + asem1_costs[i-1][2] + n3_cost.get(i));
            pp3[i] = minimum(pp3[i - 1] + n3_cost.get(i), pp2[i - 1] + asem1_costs[i-1][2] + n2_cost.get(i), pp1[i - 1] + asem1_costs[i-1][0] + n1_cost.get(i));
        }
        return minimum(pp1[n-1],pp2[n-1],pp3[n-1]);
    }
      public static int recur_cost(int asem1_costs[][], ArrayList<Integer>n1_cost, ArrayList<Integer>n2_cost,ArrayList<Integer>n3_cost,int n) {
       int pp1[];
        pp1 = new int[5];
        int pp2[] = new int[5];
        int pp3[] = new int[5];

        Bestpath obj = new Bestpath();
pp1[0]=5;
pp2[0]=4;
pp3[0]=2;
        for (int i = 1; i < n; i++) {
            
            
            pp1[i] = minimum(pp1[i - 1] + n1_cost.get(i), pp2[i - 1] + asem1_costs[i-1][1]+ n2_cost.get(i), pp3[i - 1] +asem1_costs[i-1][0] + n3_cost.get(i));
           
            pp2[i] = minimum(pp2[i - 1] + n2_cost.get(i), pp1[i - 1] + asem1_costs[i-1][1] + n2_cost.get(i), pp3[i - 1] + asem1_costs[i-1][2] + n3_cost.get(i));
            pp3[i] = minimum(pp3[i - 1] + n3_cost.get(i), pp2[i - 1] + asem1_costs[i-1][2] + n2_cost.get(i), pp1[i - 1] + asem1_costs[i-1][0] + n1_cost.get(i));
        }
        return minimum(pp1[n-1],pp2[n-1],pp3[n-1]);
    }
    public static void main(String[] args) {
        // TODO code application logic here

        ArrayList<Integer> n1_cost = new ArrayList<>();

        ArrayList<Integer> n2_cost = new ArrayList<>();
        ArrayList<Integer> n3_cost = new ArrayList<>();
       n1_cost.add(0);
       n2_cost.add(0);
       n3_cost.add(0);
        for (int i = 0; i < 5; i++) {
            Random rand = new Random();
            int randomNum = rand.nextInt((5 - 1) + 1) + 1;
            n1_cost.add(randomNum);
            int randomNum1 = rand.nextInt((5 - 1) + 1) + 1;
            n2_cost.add(randomNum1);
            int randomNum2 = rand.nextInt((5 - 1) + 1) + 1;
            n3_cost.add(randomNum2);
        }
        System.out.println(n1_cost + " " + n2_cost + " " + n3_cost);

  
     int  asem1_costs[][] = new int[5][3];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                
                    Random rand = new Random();
                    int randomNum3 = rand.nextInt((5 - 1) + 1) + 1;
                    
                   
                    asem1_costs[i][j]=randomNum3;
                
            }
             System.out.println(asem1_costs[i][0] + " " + asem1_costs[i][1] + " " + asem1_costs[i][2]);

        }
        
      int xx=minicost(asem1_costs,n1_cost,n2_cost,n3_cost,n3_cost.size()-1);
System.out.println("minimum possible cost  "+xx);

ArrayList<Integer> path_to_follow = new ArrayList<>();

    }

  
}








