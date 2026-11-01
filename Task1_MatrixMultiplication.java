import java.util.Random;

public class Task1_MatrixMultiplication {
    public static void main(String[] args) {
        int N = 2048;
        double[][] A = new double[N][N];
        double[][] B = new double[N][N];
        double[][] C = new double[N][N];

        Random rand = new Random(42);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = rand.nextDouble();
                B[i][j] = rand.nextDouble();
            }
        }

        System.out.println("Starting matrix multiplication (2048x2048, i-j-k)...");
        long startTime = System.nanoTime();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                double sum = 0.0;
                for (int k = 0; k < N; k++) {
                    sum += A[i][k] * B[k][j];
                }
                C[i][j] = sum;
            }
        }

        long endTime = System.nanoTime();
        double durationSeconds = (endTime - startTime) / 1e9;

        System.out.printf("Execution completed in: %.4f seconds\n", durationSeconds);
    }
}