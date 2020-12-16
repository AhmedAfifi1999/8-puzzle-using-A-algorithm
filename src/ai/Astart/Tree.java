package ai.Astart;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class Tree {

    Node root;
    static int[][] intial = {{2, 3, 6},
    {8, 0, 5},
    {4, 1, 7}};

    final static int[][] Goal = {{1, 2, 3},
    {8, 0, 4},
    {7, 6, 5}};

    public void traverseTree(Node node) {
        int[][] temp = node.getArray();
        if (node != null) {
            int[][] left, right, up, down;
            int FLeft = 1000, FRight = 1000, FUp = 1000, FDown = 1000;
            Map<String, Integer> maping
                    = new HashMap<String, Integer>();
            printarray(node.getArray());
            System.out.println("--------");
            down = MoveDown(node.getArray());
            printarray(node.getArray());
            System.out.println("-------");
            right = MoveRight(node.getArray());
            printarray(node.getArray());

            up = MoveUp(node.getArray());
            left = MoveLeft(node.getArray());

            if (right != null) {

                Node rightNode = new Node(right);
                node.setRight(rightNode);
                rightNode.setG((node.getG() + 1));
                FRight = rightNode.getFun();
                System.out.println("fringht" + FRight);
                maping.put("right", FRight);
                traverseTree(rightNode.getRight());
            }
            if (up != null) {
                Node upNode = new Node(up);
                upNode.setG(node.getG() + 1);
                FUp = upNode.fun;
                maping.put("up", FUp);
                traverseTree(upNode.up);

            }
            if (down != null) {
                Node downNode = new Node(down);
                downNode.setG(node.getG() + 1);
                FDown = downNode.fun;
                maping.put("down", FDown);
                traverseTree(downNode.down);

            }
            if (left != null) {
                Node leftNode = new Node(left);
                leftNode.setG(node.getG() + 1);
                FLeft = leftNode.fun;
                maping.put("left", FLeft);
                traverseTree(leftNode.left);

            }
            System.out.println("FRight : " + FRight);


            /*for (Map.Entry<String, Integer> entry : maping.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();

            }*/
 /*   traverseTree(node.left);
            System.out.print(" " + node.left);
            traverseTree(node.right);*/
        }

    }

    public static int[][] MoveRight(int[][] array) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (array[i][j] == 0) {
                    if (j + 1 == 3) {

                        return null;
                    } else {

                        int swap = array[i][j];
                        array[i][j] = array[i][j + 1];
                        array[i][j + 1] = swap;
                        return array;
                    }
                }
            }
        }
        return array;
    }

    public static int[][] MoveLeft(int[][] array) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (array[i][j] == 0) {

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
            }
        }
        return array;
    }

    public static int[][] MoveUp(int[][] array) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (array[i][j] == 0) {

                    if (i - 1 == -1) {

                        return null;
                    } else {
                        int swap = array[i][j];
                        array[i][j] = array[i - 1][j];
                        array[i - 1][j] = swap;
                        return array;
                    }

                }
            }
        }
        return array;
    }

    public static int[][] MoveDown(int[][] array) {
        int[][] result = array;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (result[i][j] == 0) {
                    if (i + 1 == 3) {

                        return null;
                    } else {
                        int swap = result[i][j];
                        result[i][j] = result[i + 1][j];
                        result[i + 1][j] = swap;
                        return result;
                    }
                }
            }
        }
        return result;
    }

    public static Map<Integer, int[][]> Move(int[][] arr) {
        int[][] value = new int[0][3];
        Map<Integer, int[][]> maping
                = new HashMap<>();
        int[][] left, right, up, down;
        left = right = up = down = arr;

        // Left , Right , Up , Down //
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 0) {

                    //left 
                    Move.MoveLeft(left, i, j);
                    maping.put(0, left);
                    printarray(left);
                    System.out.println("-----");

                    //Right
                    Move.MoveRight(right, i, j);
                    maping.put(1, right);
                    printarray(right);
                    System.out.println("-----");

                    //Up 
                    Move.MoveUp(up, i, j);
                    maping.put(2, up);
                    printarray(up);
                    System.out.println("-----");

                    // Down
                    Move.MoveDown(down, i, j);
                    maping.put(3, down);
                    printarray(down);
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
        /*  Tree tree = new Tree();
        Node z = new Node(intial);
        z.setG(0);
        tree.traverseTree(z);

        int h = calcH(intial, Goal);

        System.out.println("h : " + h);*/

        Move(intial);
    }
}
