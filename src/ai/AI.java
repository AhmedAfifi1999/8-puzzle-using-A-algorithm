/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author A7med
 */
public class AI {

    //   int[][] intial = new int[3][3];
    //2 3 6 0 4 5 8 1 7
    static int[][] intial = {{2, 3, 6},
    {0, 4, 5},
    {8, 1, 7}};
    final static int[][] Goal = {{1, 2, 3},
    {8, 0, 4},
    {7, 6, 5}};
    static int g = 0;

    static ArrayList<int[][]> arraylist;

    public static int calcH(int[][] array, int[][] goal) {
        if (array == null) {
            return 10;
            //H cant be 10  , just for check cant be  move

        } else {
            int h = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (array[i][j] == goal[i][j]) {

                        if (array[i][j] != 0) {
                            h++;
                        }
                    }
                }
            }
            return 8 - h;

        }
    }

    public static int[][] MoveLeft(int[][] array, int i, int j) {
        if (j - 1 == -1) {

            return null;
        } else {
            int[][] result = array;
            int swap = result[i][j];
            result[i][j] = result[i][j - 1];
            result[i][j - 1] = swap;
            return result;
        }
    }

    public static int[][] MoveRight(int[][] array, int i, int j) {

        if (j + 1 == 3) {

            return null;
        } else {

            int swap = array[i][j];
            array[i][j] = array[i][j + 1];
            array[i][j + 1] = swap;
            return array;
        }
    }

    public static int[][] MoveUp(int[][] array, int i, int j) {

        if (i - 1 == -1) {

            return null;
        } else {
            int swap = array[i][j];
            array[i][j] = array[i - 1][j];
            array[i - 1][j] = swap;
            return array;
        }
    }

    public static int[][] MoveDown(int[][] array, int i, int j) {
        if (i + 1 == 3) {

            return null;
        } else {
            int swap = array[i][j];
            array[i][j] = array[i + 1][j];
            array[i + 1][j] = swap;
            return array;
        }
    }

    public static void getFunction(int[][] array) {
        int hleft, hright, hup, hdown;
        int[][] left, right, up, down;
       // Map< Integer,Integer> hm = new HashMap<String,Integer>(); 

        int[] values = new int[4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (array[i][j] == 0) {
                    //// check if can i go for left right up or down
                    System.out.println("i= : " + i + " j = :" + j + "\n");
                    System.out.println("---------------");

                    left = MoveLeft(array, i, j);
                    printarray(left);
                    hleft = calcH(left, Goal);
                    values[0] = hleft;
                    System.out.println("h left = :" + hleft);

                    System.out.println("---------------");
                    right = MoveRight(array, i, j);
                    printarray(right);
                    hright = calcH(right, Goal);
                    values[1] = hright;
                    System.out.println("h right = :" + hright);

                    System.out.println("---------------");
                    up = MoveUp(array, i, j);
                    printarray(up);
                    hup = calcH(up, Goal);
                    values[2] = hup;
                    System.out.println("h up = :" + hup);

                    System.out.println("---------------");
                    down = MoveDown(array, i, j);
                    printarray(down);
                    hdown = calcH(down, Goal);
                    values[3] = hdown;
                    System.out.println("h down = :" + hdown);

                    System.out.println("---------");
                   // Arrays.sort(values);
                    //System.out.println(Arrays.toString(values));
             
                    
             
                    
                    break;

                }

            }
        }
    }

    public static void printarray(int a[][]) {
        if (a != null) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    System.out.printf("%5d ", a[i][j]);
                }
                System.out.println();
            }
        }

    }

    
    public static void main(String[] args) {

        /*    int h;
         printarray(MoveRight(intial, 1, 0));

        h = calcH(MoveRight(intial, 1, 0), Goal);
        System.out.println("H = " + h);
         */
        //getFunction(intial);
      
    }

}
