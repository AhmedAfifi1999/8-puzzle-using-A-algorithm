/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.Astart;

/**
 *
 * @author A7med
 */
public class Move {

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
            System.out.println("i : " + i);
            int swap = array[i][j];
            array[i][j] = array[i + 1][j];
            array[i + 1][j] = swap;
            return array;
        }
    }

}
