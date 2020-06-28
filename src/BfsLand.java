public class BfsLand {

    public static int[][] map2;

    public static void go(int x, int y, int mark) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};


        if (x >= 0 && x < map2[0].length && y >= 0 && y < map2.length) {
            if (map2[y][x] != 0)
                return;

            map2[y][x] = mark;

            for (int i = 0; i < 4; i++) {
                go(x + dx[i], y + dy[i], mark);
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[][] map = load();
        map2 = load();
        int H = map.length;
        int W = map[0].length;


        int land = 2;
        printMap(map2);
        for (int j = 0; j < H; j++) {
            for (int i = 0; i < W; i++) {
                if (map2[j][i] == 0) {
                    go(i, j, land);
                    System.out.println(String.format("(%d,%d)", i, j));
                    printMap(map2);
                    land++;
                }
            }
        }

        // count each map size
        int[] table = new int[land];
        for (int j = 0; j < H; j++) {
            for (int i = 0; i < W; i++) {
                if (map2[j][i] != 1) {
                    table[map2[j][i]]++;
                }
            }
        }

        // get maximum size
        int count = 0;
        for (int i = 0; i < land; i++) {
            if (table[i] != 0) {
                System.out.print(table[i] + " ");
                count = i;
            }
        }

        System.out.println();
        System.out.println(count - 1);

    }

    public static int[][] load() {
        int[][] map = {
                {0, 0, 1, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 0, 0, 1, 1},
                {0, 0, 1, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1, 1, 0, 1, 1, 1},
                {0, 1, 1, 0, 1, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        return map;
    }

    public static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
}
