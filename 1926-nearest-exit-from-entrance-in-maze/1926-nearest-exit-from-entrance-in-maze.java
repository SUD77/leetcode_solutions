class Solution {
    private int[][] dirs = new int[][]{
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    };
    private class Pair {
        int[] coordinate;
        int steps;
        public Pair(int[] coordinate, int steps) {
            this.coordinate = coordinate;
            this.steps = steps;
        }
    }
    private int m;
    private int n;

    public int nearestExit(char[][] maze, int[] entrance) {
        m = maze.length;
        n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        visited[entrance[0]][entrance[1]] = true;
        q.offer(new Pair(entrance, 0));

        while (!q.isEmpty()) {
            int[] coordinate = q.peek().coordinate;
            int steps = q.peek().steps;
            q.poll();

            if (coordinate != entrance && isBorder(coordinate)) {
                return steps;
            }

            for (int[] dir : dirs) {
                int x = coordinate[0] + dir[0];
                int y = coordinate[1] + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n) {
                    continue;
                }
                if (visited[x][y] || maze[x][y] == '+') {
                    continue;
                }
                visited[x][y] = true;
                q.offer(new Pair(new int[]{x, y}, steps + 1));
            }
        }

        return -1;
    }

    private boolean isBorder(int[] coordinate) {
        return coordinate[0] == 0 || 
            coordinate[0] == m - 1 || 
            coordinate[1] == 0 || 
            coordinate[1] == n - 1;
    }
}