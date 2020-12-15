package ai.Astart;

public class Node {

    final static int[][] Goal = {{1, 2, 3},
    {8, 0, 4},
    {7, 6, 5}};
    int[][] array;
    int h = calcH(array, Goal);
    int g;
    Node left;
    Node right;
    Node up;
    Node down;
    int fun = g + h;

    public Node(int[][] array) {
        this.array = array;
        left = right = up = down = null;

    }

    public int[][] getArray() {
        return array;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getFun() {
        return fun;
    }

    public void setFun(int fun) {
        this.fun = fun;
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

}
