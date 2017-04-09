package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//an unsolved problem
public class CastleOnTheGrid {
    static int c = 0;
    static int d = 0;
    static Map<String, String> direction = new HashMap<>();
    private static int cache[][];
    private static boolean visited[][];

    static {
        direction.put("-1-1", "NW");
        direction.put("0-1", "N");
        direction.put("1-1", "NE");
        direction.put("-10", "W");
        direction.put("00", "-");
        direction.put("10", "E");
        direction.put("-11", "SW");
        direction.put("01", "S");
        direction.put("11", "SE");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[][] cells = new char[n][n];

        cache = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            cells[i] = in.next().toCharArray();
        }
        int a = in.nextInt();
        int b = in.nextInt();
        c = in.nextInt();
        d = in.nextInt();
        int min = Integer.MAX_VALUE;
        visited[a][b] = true;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int newX = a + i;
                int newY = b + j;
                if (newX >= 0 && newX < cells.length
                        && newY >= 0 && newY < cells.length
                        && cells[newX][newY] != 'X') {
                    System.out.println(direction.get(j + "" + i));
                    min = Math.min(shortestPath(cells, newX, newY, direction.get(j + "" + i)), min);
                }
            }
        }
        System.out.println(min);
    }


    private static int shortestPath(char cells[][], int x, int y, String dir) {
        System.out.println("to " + x + "," + y + " in " + dir);
        //visited[x][y] = true;
        if (x == c && y == d) {
            System.out.println("Found!!!");
            visited[x][y] = false;
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int newX = x + i;
                int newY = y + j;
                if (newX >= 0 && newX < cells.length
                        && newY >= 0 && newY < cells.length
                        && !visited[newX][newY]
                        && cells[newX][newY] != 'X') {
                    visited[newX][newY] = true;
                    System.out.println(direction.get(j + "" + i));
                    int cost = shortestPath(cells, newX, newY, direction.get(j + "" + i));
                    if (cost != Integer.MAX_VALUE) {
                        int a = direction(i, j, dir) + cost;
                        System.out.println(x + "," + y + " cost:" + a);
                        min = Math.min(a, min);
                    }
                    visited[newX][newY] = false;

                }
            }
        }
        cache[x][y] = min;
        System.out.println("returned " + min);
        return min;
    }

    private static int direction(int i, int j, String dir) {
        if (dir.equals(direction.get(j + "" + i))) {
            return 0;
        }
        return 1;
    }
}
