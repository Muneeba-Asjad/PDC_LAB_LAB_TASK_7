import java.util.Random;

public class Task6_MatrixScaling {
    public static void main(String[] args) {
        int[] sizes = { 128, 256, 512, 1024 };
        Random rand = new Random(42);

        System.out.printf("%-12s %-20s %-20s\n", "Size (N)", "Execution Time (s)", "Complexity Growth (N^3)");
        System.out.println("---------------------------------------------------------");

        for (int N : sizes) {
            double[][] A = new double[N][N];
            double[][] B = new double[N][N];
            double[][] C = new double[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    A[i][j] = rand.nextDouble();
                    B[i][j] = rand.nextDouble();
                }
            }

            long start = System.nanoTime();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    double sum = 0.0;
                    for (int k = 0; k < N; k++) {
                        sum += A[i][k] * B[k][j];
                    }
                    C[i][j] = sum;
                }
            }
            long end = System.nanoTime();
            double duration = (end - start) / 1e9;

            System.out.printf("%-12d %-20.6f %-20d\n", N, duration, (long) N * N * N);
        }
    }
}