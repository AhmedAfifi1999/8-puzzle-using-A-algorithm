package ai.Astart;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Tree {

    Node root;
    static int[][] intial = {{2, 3, 6},
    {8, 0, 5},
    {4, 1, 7}};

    final static int[][] Goal = {{1, 2, 3},
    {8, 0, 4},
    {7, 6, 5}};

    public static int[][] copy(int[][] arr) {
        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = arr[i][j];
            }
        }

        return result;
    }

    public int[] CreateNode(int[][] left, int[][] right, int[][] up, int[][] down, Node node) {
        int[] result = new int[4];

        if (left != null) {
            Node leftNode = new Node(left);
            leftNode.setG(node.getG() + 1);
            result[0] = leftNode.getFun();
            // traverseTree(leftNode.left);
            System.out.println("left: " + result[0]);

        }
        if (right != null) {
            Node rightNode = new Node(right);
            // node.setRight(rightNode);
            rightNode.setG((node.getG() + 1));
            result[1] = rightNode.getFun();
            //  traverseTree(rightNode.getRight());
            System.out.println("Right: " + result[1]);
        }
        if (up != null) {
            Node upNode = new Node(up);
            upNode.setG(node.getG() + 1);
            result[2] = upNode.getFun();
            //       traverseTree(upNode.up);
            System.out.println("UP: " + result[2]);

        }
        if (down != null) {
            Node downNode = new Node(down);
            downNode.setG(node.getG() + 1);
            result[3] = downNode.getFun();
            //  traverseTree(downNode.down);
            System.out.println("down: " + result[3]);

        }

        return result;
    }

    public void traverseTree(Node node) {

        if (node != null) {
            int[][] left, right, up, down;
            int FLeft, FRight, FUp, FDown;
            Map<Integer, int[][]> maping = Move(node.getArray());
            // Left , Right , Up , Down //

            left = maping.get(0);
            right = maping.get(1);
            up = maping.get(2);
            printarray(up);

            down = maping.get(3);
            int[] result = CreateNode(left, right, up, down, node);
            System.out.println(Arrays.toString(result));
        }

    }

    public static Map<Integer, int[][]> Move(int[][] arr) {
        int[][] left = copy(arr);
        int[][] right = copy(arr);
        int[][] up = copy(arr);
        int[][] down = copy(arr);
        Map<Integer, int[][]> maping
                = new HashMap<>();

        // Left , Right , Up , Down //
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 0) {
                 //   System.out.println(" i : " + i + " j : " + j);
                    //left 
                    left = Move.MoveLeft(left, i, j);
                    maping.put(0, left);
                    //  printarray(left);
                    System.out.println("-----");

                    //Right
                    right = Move.MoveRight(right, i, j);
                    maping.put(1, right);
                    //  printarray(right);
                    System.out.println("-----");

                    //Up 
                    up = Move.MoveUp(up, i, j);
                    maping.put(2, up);
                    //  printarray(up);
                    System.out.println("-----");

                    // Down
                    down = Move.MoveDown(down, i, j);
                    maping.put(3, down);
                    //  printarray(down);
                    System.out.println("-----");

                    break;
                }
            }
        }

        return maping;
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

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node z = new Node(intial);
        z.setG(0);

        System.out.println(z.getFun());
        tree.traverseTree(z);

        // int h = calcH(intial, Goal);
        // System.out.println("h : " + h);*/
        // Move(intial);
    }
}
