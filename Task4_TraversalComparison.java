public class Task4_TraversalComparison {
    private static final int ROWS = 8000;
    private static final int COLS = 8000;

    public static void main(String[] args) {
        int[][] matrix = new int[ROWS][COLS];
        int RUNS = 5;
        long totalRowTime = 0;
        for (int r = 0; r < RUNS; r++) {
            long start = System.nanoTime();
            long sum = 0;
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    sum += matrix[i][j];
                }
            }
            totalRowTime += (System.nanoTime() - start);
        }
        long totalColTime = 0;
        for (int r = 0; r < RUNS; r++) {
            long start = System.nanoTime();
            long sum = 0;
            for (int j = 0; j < COLS; j++) {
                for (int i = 0; i < ROWS; i++) {
                    sum += matrix[i][j];
                }
            }
            totalColTime += (System.nanoTime() - start);
        }
        System.out.printf("Average Row-Wise Traversal Time:    %.4f ms\n", (totalRowTime / (double) RUNS) / 1e6);
        System.out.printf("Average Column-Wise Traversal Time: %.4f ms\n", (totalColTime / (double) RUNS) / 1e6);
    }
}