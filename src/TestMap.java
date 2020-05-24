public class TestMap {
    public static void main(String[] args) {
        int[][] map = {{1, 2, 4, 1, 5, 5}, {2, 5, 2, 1, 4, 5}, {2, 5, 2, 1, 5, 6}, {1, 3, 4, 2, 5, 1}, {1, 2, 5, 2, 4, 1}, {2, 5, 1, 4, 3, 4}};
        System.out.println(sum(map, 6 - 1, 6 - 1));
    }//end

    public static int sum(int[][] map, int x, int y) {
        if (x == 0 && y == 0) return map[x][y];
        else if (x == 0) return sum(map, x, y - 1) + map[x][y];
        else if (y == 0) return sum(map, x - 1, y) + map[x][y];
        else return max(sum(map, x - 1, y), sum(map, x, y - 1)) + map[x][y];
    }

    public static int max(int n1, int n2) {
        return (n1 > n2) ? n1 : n2;
    }
}
