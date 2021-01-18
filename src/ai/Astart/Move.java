/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.Astart;

import java.util.Arrays;

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

    public static int MinNumber(int s1, int s2, int s3, int s4) {
        int min = s1;
        min = (min < s2) ? min : s2;
        min = (min < s3) ? min : s3;
        min = (min < s4) ? min : s4;
        return min;
    }

    public static int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static boolean equal(final int[][] arr1, final int[][] arr2) {

        if (arr1 == null) {

            return (arr2 == null);

        }

        if (arr2 == null) {

            return false;

        }

        if (arr1.length != arr2.length) {

            return false;

        }

        for (int i = 0; i < arr1.length; i++) {

            if (!Arrays.equals(arr1[i], arr2[i])) {

                return false;

            }

        }

        return true;
    }
}
