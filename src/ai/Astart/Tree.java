package ai.Astart;

import java.util.HashMap;
import java.util.Map;

public class Tree {

    Node root;
    static int[][] intial = {{2, 3, 6},
                            {0, 4, 5},
                            {8, 1, 7}};

    public void traverseTree(Node node) {
        if (node != null) {
            int[][] left, right, up, down;
            int hleft = 1000, hright = 1000, hup = 1000, hdown = 1000;
            Map<String, Integer> maping
                    = new HashMap<String, Integer>();

            down = MoveDown(node.getArray());
            right = MoveRight(node.getArray());
            up = MoveUp(node.getArray());
            left = MoveUp(node.getArray());

            if (right != null) {
                Node rightNode = new Node(right);
                rightNode.setG(node.getG() + 1);
                hright = rightNode.fun;
                maping.put("right", hright);
            }
            if (up != null) {
                Node upNode = new Node(up);
                upNode.setG(node.getG() + 1);
                hup = upNode.fun;
                maping.put("up", hup);

            }
            if (down != null) {
                Node downNode = new Node(down);
                downNode.setG(node.getG() + 1);
                hdown = downNode.fun;
                maping.put("down", hdown);

            }
            if (left != null) {
                Node leftNode = new Node(left);
                leftNode.setG(node.getG() + 1);
                hleft = leftNode.fun;
                maping.put("left", hleft);

            }
            if (hleft == hright && hright == hdown && hdown == hup && hleft != 1000) {
                traverseTree(node.left);
                traverseTree(node.right);
                traverseTree(node.down);
                traverseTree(node.up);

            }

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
                } else {
                    array = null;
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

                } else {
                    array = null;
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

                } else {
                    array = null;
                }
            }
        }
        return array;
    }

    public static int[][] MoveDown(int[][] array) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (array[i][j] == 0) {
                    if (i + 1 == 3) {

                        return null;
                    } else {
                        int swap = array[i][j];
                        array[i][j] = array[i + 1][j];
                        array[i + 1][j] = swap;
                        return array;
                    }
                } else {
                    array = null;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        /*   Tree tree = new Tree();
        tree.root = new Node(intial);
        tree.root.setG(0);*/

    }
}
